<#import "/resource/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>
<#import "/account/accountMenu.ftl" as accountMenu>
<@html.htmlBase>
<style type="text/css">
    .centerImageCss{
        width: 560px;
        height: 180px;
    }
</style>
    <@menu.menu selectMenu=""/>
<div class="container" style="margin-top: 0px;padding-top: 0px;">
    <div class="row">
        <div class="col-xs-3" style="min-height: 300px;">
            <@accountMenu.accountMenu currentMenu="discount"/>
        </div>

        <div class="col-xs-9" style="min-height: 200px;">

            <div class="row">
                <div class="col-xs-12">
                    <ol class="breadcrumb">
                        <li class="active">我的优惠券</li>
                    </ol>
                </div>
            </div>

            <hr>
            <div class="row">
                <h5>已领的优惠券</h5>
                <#if discountList??>
                    <table class="table table-bordered table-hover" style="margin-bottom: 10px;">
                        <tr style="background-color: #dff0d8">
                            <th style="text-align: center;">优惠券名称</th>
                            <th style="text-align: center;">使用条件</th>
                            <th style="text-align: center;">面值</th>
                            <th style="text-align: center;">有效期</th>
                            <th style="text-align: center;">限购商品</th>
                            <th style="text-align: center;">状态</th>
                            <th style="text-align: center;">操作</th>
                        </tr>
                        <#list discountList as item>
                            <tr>
                                <td style="display: none;">${item.id!""}</td>
                                <td style="text-align: center;">
                                    <#if item.name?? && item.name=="all">
                                     全部商品
                                    <#else>
                                      ${item.name!""}
                                     </#if>
                                </td>
                                <td style="text-align: center;">
                                     <#if item.cutType?? && item.cutType=="0">
                                           不限制
                                         <#else>
                                             <#if item.cutnum??>
                                                满${item.cutnum!""}元减
                                             </#if>
                                     </#if>
                                     </td>
                                <td style="text-align: center;">${item.facevale!""}</td>
                                <td style="text-align: center;">${item.begintime!""}到${item.endtime!""}</td>
                                <td style="text-align: center;">${item.pname!""}</td>
                                <td style="text-align: center;">
                                             <#if item.canuse?? && item.canuse =="0" >
                                                 不可用
                                             <#elseif  item.canuse?? && item.canuse =="1" >
                                                     可用
                                             <#elseif  item.canuse?? && item.canuse =="2" >
                                                  已使用
                                            <#elseif  item.canuse?? && item.canuse =="3" >
                                               已过期
                                             <#elseif  item.canuse?? && item.canuse =="4" >
                                                 已使用
                                            <#else>
                                                 状态异常
                                    </#if>
                               </td>
                                <td nowrap="nowrap" style="text-align: center;">
                                    <#if item.orderid?? >
                                       查看订单
                                    <#else>
                                        立即使用
                                    </#if>
                                </td>
                            </tr>
                        </#list>
                    </table>
                <#else>
                    <!--
                    <div class="bs-callout bs-callout-danger author" style="text-align: left;font-size: 14px;margin: 2px 0px;">
                        还没有任何配送信息！赶紧添加吧。
                    </div>
                     -->

                    <div class="col-xs-12">
                        <hr>
                        <div class="row">
                            <div class="col-xs-12" style="font-size: 14px;font-weight: normal;">
                                <div class="panel panel-default">
                                    <div class="panel-body" style="font-size: 16px;font-weight: normal;text-align: center;">
                                        <div class="panel-body" style="font-size: 16px;font-weight: normal;text-align: center;">
                                            <span class="glyphicon glyphicon-user"></span>亲，还没有任何优惠券记录哦！赶紧去抢优惠券吧。
                                        </div>
                                    </div>
                                </div>
                                <hr>
                            </div>
                        </div>

                    </div>

                </#if>
            </div>

            <#--可以领取的优惠券-->
            <div class="row">
                <h5>可领优惠券</h5>
                <#if discountList2??>
                    <table class="table table-bordered table-hover" style="margin-bottom: 10px;">
                        <tr style="background-color: #dff0d8">
                            <th style="text-align: center;">优惠券名称</th>
                         <#--   <th style="text-align: center;">使用条件</th>
                            <th style="text-align: center;">面值</th>-->
                            <th style="text-align: center;">有效期</th>
                            <th style="text-align: center;">限购商品</th>
                            <th style="text-align: center;">兑换金额</th>
                          <#--  <th style="text-align: center;">状态</th>-->
                            <th style="text-align: center;">操作</th>
                        </tr>
                        <#list discountList2 as item>
                            <tr>
                                <td style="display: none;">${item.id!""}</td>
                                <td style="text-align: center;">
                                     <#if item.name?? && item.name=="all">
                                        全部商品
                                     <#else>
                                        ${item.name!""}
                                     </#if>
                                     </td>
                              <#--  <td style="text-align: center;">
                                    <#if item.cutType?? && item.cutType=="0">
                                        不限制
                                    <#else>
                                        <#if item.cutnum??>
                                            满${item.cutnum!""}元减
                                        </#if>
                                    </#if>
                                </td>
                                <td style="text-align: center;">${item.facevale!""}</td>-->
                                <td style="text-align: center;">${item.begintime!""}到${item.endtime!""}</td>
                                <td style="text-align: center;">${item.pname!""}</td>
                                <td style="text-align: center;">
                                     <#if  item.converttype?? && item.converttype ==1 >
                                            ${item.convertnum!""}元
                                     <#elseif  item.converttype?? && item.converttype ==2 >
                                         ${item.convertnum!""}燊活币
                                     <#elseif  item.converttype?? && item.converttype ==3 >
                                        ${item.convertnum!""}积分
                                     <#elseif item.converttype?? && item.converttype ==0 >
                                         0元
                                     <#else>
                                         异常数据
                                     </#if>
                                 </td>
                             <#--   <td style="text-align: center;">
                                    <#if item.canuse?? && item.canuse =="0" >
                                        不可用
                                    <#elseif  item.canuse?? && item.canuse =="1" >
                                        可用
                                    <#elseif  item.canuse?? && item.canuse =="2" >
                                        已使用
                                    <#elseif  item.canuse?? && item.canuse =="3" >
                                        已过期
                                    <#elseif  item.canuse?? && item.canuse =="4" >
                                        已使用
                                    <#else>
                                        异常数据
                                    </#if>
                                </td>-->
                                <td nowrap="nowrap" style="text-align: center;">
                                     <#if item.converttype?? && item.converttype ==0 && item.isGet ==0>
                                        领用
                                    <#elseif item.converttype?? && item.converttype !=0 && item.isGet ==0>
                                        兑换
                                     <#elseif item.isGet?? && item.isGet ==1 >
                                         已领取
                                     <#else>
                                         异常数据
                                     </#if>
                                </td>
                            </tr>
                        </#list>
                    </table>
                <#else>
                    <!--
                    <div class="bs-callout bs-callout-danger author" style="text-align: left;font-size: 14px;margin: 2px 0px;">
                        还没有任何配送信息！赶紧添加吧。
                    </div>
                     -->

                    <div class="col-xs-12">
                        <hr>
                        <div class="row">
                            <div class="col-xs-12" style="font-size: 14px;font-weight: normal;">
                                <div class="panel panel-default">
                                    <div class="panel-body" style="font-size: 16px;font-weight: normal;text-align: center;">
                                        <div class="panel-body" style="font-size: 16px;font-weight: normal;text-align: center;">
                                            <span class="glyphicon glyphicon-user"></span>亲，暂时没有优惠券！去看看别的吧。
                                        </div>
                                    </div>
                                </div>
                                <hr>
                            </div>
                        </div>

                    </div>

                </#if>

            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function() {
        $("input[name=setDefaultRadio]").click(function(){
            var $this = $(this);
            var current = $this.attr("current");
            if(current == "1") {
                return false;
            }
            var _url = "setAddressDefault";
            //alert(_url);
            $.ajax(_url,{
                type: 'POST',
                data: {id:$this.val()},
                success: function(data){
                    $(":radio[name=setDefaultRadio][current=1]").attr("current", "0");
                    $this.attr("current", "1");
                    alert("修改默认地址成功！");
                },
                dataType: "json",
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    alert("操作失败，请联系管理员或更换浏览器再试!");
                }
            });
        });
    });
    function search(){
        var _key = $.trim($("#key").val());
        if(_key==''){
            return false;
        }
        $("#searchForm").submit();
    }
    function deletes(){
        return confirm("确定删除选择的记录?");
    }
    function changeProvince(){
        var selectVal = $("#province").val();
        if(!selectVal){
            console.log("return;");
            return;
        }
        var _url = "selectCitysByProvinceCode?provinceCode="+selectVal;
        console.log("_url="+_url);
        $("#citySelect").empty().show().append("<option value=''>--选择城市--</option>");
        $("#areaSelect").empty().show().append("<option value=''>--选择区县--</option>");
        $.ajax({
            type: 'POST',
            url: _url,
            data: {},
            dataType: "json",
            success: function(data){
                //console.log("changeProvince success!data = "+data);
                $.each(data,function(index,value){
                    //console.log("index="+index+",value="+value.code+","+value.name);
                    $("#citySelect").append("<option value='"+value.code+"'>"+value.name+"</option>");
                });
            },
            error:function(er){
                console.log("changeProvince error!er = "+er);
            }
        });
    }

    function changeCity(){
        var selectProvinceVal = $("#province").val();
        var selectCityVal = $("#citySelect").val();
        if(!selectProvinceVal || !selectCityVal){
            console.log("return;");
            return;
        }
        var _url = "selectAreaListByCityCode?provinceCode="+selectProvinceVal+"&cityCode="+selectCityVal;
        console.log("_url="+_url);
        $("#areaSelect").empty().show().append("<option value=''>--选择区县--</option>");
        $.ajax({
            type: 'POST',
            url: _url,
            data: {},
            dataType: "json",
            success: function(data){
                //console.log("changeProvince success!data = "+data);
                $.each(data,function(index,value){
                    //console.log("index="+index+",value="+value.code+","+value.name);
                    $("#areaSelect").append("<option value='"+value.code+"'>"+value.name+"</option>");
                });
            },
            error:function(er){
                console.log("changeCity error!er = "+er);
            }
        });
    }
</script>
</@html.htmlBase>