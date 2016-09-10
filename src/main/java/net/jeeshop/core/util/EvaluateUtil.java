package net.jeeshop.core.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/***
 * 自动赋值 
 * 根据properties给ParamUtil 自动赋值（目前支持list、string、map、Integer）
 * hanrb
 * **/
public class EvaluateUtil {
    private Properties propertie = new Properties();
    {
        try {
            propertie.load(EvaluateUtil.class.getResourceAsStream("/param.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void autoEvalVal(){
        try {
            Class<?> clazz = Class.forName("net.jeeshop.thirdParty.miaodiyun.httpApiDemo.common.Config");
            for(Field field:clazz.getFields()){
                //获取修饰字段类型
                String fieldType = field.getType().getSimpleName();
                //获取properties文件里的值
                String value = propertie.getProperty(field.getName());
                //根据字段进行赋值 支持list map integer string
                if("List".equals(fieldType)){
                    String arrayStr[] = value.split(",");
                    ParameterizedType parameterizedType=(ParameterizedType)field.getGenericType();
                    //获取泛型类型
                    Class<?> parameterizedClass = (Class<?>)parameterizedType.getActualTypeArguments()[0];
                    //对比泛型 目前为integer 与 STRING
                    if("String".equals(parameterizedClass.getSimpleName())){
                        List<String> list = new ArrayList<String>();
                        for(String s:arrayStr){
                            list.add(s);
                        }
                        field.set(new ArrayList<String>(), list);
                    }else if("Integer".equals(parameterizedClass.getSimpleName())){
                        List<Integer> list = new ArrayList<Integer>();
                        for(String s:arrayStr){
                            list.add(Integer.parseInt(s));
                        }
                        field.set(new ArrayList<Integer>(), list);
                    }
                }else
                if("Map".equals(fieldType)){
                    //解析json串
                    JSONArray array= (JSONArray)JSONValue.parse(value);
                    Map<String,String> map = new HashMap<String,String>();
                    for(Iterator iterator=array.iterator();iterator.hasNext();){
                        JSONObject jsonObj=(JSONObject)iterator.next();
                        Set<Map.Entry<String,String>> obj=jsonObj.entrySet();
                        String k = null;
                        String v = null;
                        for(Map.Entry<String,String> entry:obj){
                            k=entry.getKey();
                            v=entry.getValue();
                        }
                        map.put(k, v);
                    }
                    field.set(new HashMap<String,String>(), map);
                }else if("String".equals(fieldType)){
                    field.set(String.class, value);
                }else if("Integer".equals(fieldType) || "int".equals(fieldType)){
                    field.set(Integer.class, Integer.parseInt(value));
                }
            }

            //System.out.println(clazz.getField("ee").getType());
            //System.out.println(clazz.getField("aa").getType().getComponentType());
            //System.out.println(clazz.getField("aa").getType().getDeclaredClasses());
            //System.out.println(clazz.getField("aa").getType().getMethods());

            //System.out.println(clazz.getField("aa").getType().getFields()[0].getGenericType() instanceof java.util.List);

            //Set<Entry<Object, Object>>  propertieList = propertie.entrySet();
            //for(Entry<Object, Object> obj:propertieList){
            //clazz.getField(obj.getKey().toString()).set(String.class, obj.getValue());
            //}

            //clazz.getField(name)
            //for(java.lang.reflect.Field field :clazz.getFields()){
            //	System.out.println(field.getName());
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
