<#import "/resource/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>
<#import "/account/accountMenu.ftl" as accountMenu>
<@html.htmlBase>
	<@menu.menu selectMenu=""/>
	<div class="container">
		<div class="row">
			<div class="col-xs-3">
				<@accountMenu.accountMenu currentMenu="account"/>
			</div>
			
			<div class="col-xs-9">

                <div class="row">
                    <div class="col-xs-12">
                        <ol class="breadcrumb">
                            <li class="active">个人资料</li>
                        </ol>
                    </div>
                </div>

                <hr>
				<form method="post" role="form" id="form" class="form-horizontal" action="${basepath}/account/saveSetting" theme="simple">
				  <div class="form-group">
				    <label for="account" class="col-lg-2 control-label">昵称：</label>
				    <div class="col-lg-6">
				    	<label class="radio-inline" style="padding-left: 0px;">
							${e.nickname!""}
				    		<#if e.accountType??>(${e.account})
								<#if e.accountType=="qq">(QQ登陆)
								<#elseif e.accountType=="sinawb">(新浪微博)
								<#elseif e.accountType=="alipay">(支付宝快捷)
								</#if>
							</#if>
				    	</label>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="account" class="col-lg-2 control-label">真实姓名：</label>
				    <div class="col-lg-6">
				    	<input name="trueName" type="text" class="form-control" id="trueName" value="${e.trueName!""}" placeholder="请输入真实姓名"/>
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="account" class="col-lg-2 control-label">性别：</label>
				    <div class="col-lg-8">
						<input type="radio" name="sex" value="m" ${(e.sex=="m")?string("checked","")}>男
                        <input type="radio" name="sex" value="f" ${(e.sex=="f")?string("checked","")}>女
                        <input type="radio" name="sex" value="s" ${(e.sex=="s")?string("checked","")}>保密
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="account" class="col-lg-2 control-label">生日：</label>
				    <div class="col-lg-3">
				    	<input id="birthday" name="birthday" class="Wdate form-control" value="${e.birthday!""}"
				    	type="text" onFocus="WdatePicker({isShowClear:false,readOnly:true})"/>
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="account" class="col-lg-2 control-label">邮箱：</label>
				    <div class="col-lg-6">
						<label>${e.email!""}</label>
				    	<a href="${basepath}/account/changeEmail" class="btn btn-link btn-sm">修改邮箱</a>
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="account" class="col-lg-2 control-label">所在地：</label>
				    <div class="col-lg-3">
							<select name="province" id="province" class="form-control" onchange="changeProvince()">
								<option value="">--选择省份--</option>
								<#list provinces as item>
								    <option value="${item.code}" ${(e.province??&&e.province==item.code)?string("selected", "")}>${item.name}</option>
								</#list>
							</select>
					    </div>
					    <div class="col-lg-3">
							<select class="form-control" id="citySelect" name="city">
								<option value="">--选择城市--</option>
								<#list cities as item>
									<option value="${item.code}" ${(e.city??&&e.city==item.code)?string("selected", "")}>${item.name}</option>
								</#list>
							</select>
					    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="account" class="col-lg-2 control-label">手机号：</label>
				    <div class="col-lg-6">
				    	<#if e.tel?? && e.tel!''>
						 	<input name="trueName" type="text" class="form-control" id="phone" value="${e.tel!''}" />
				    	<a href="javascript:void(0)" data-target="#bangDing"  data-toggle="modal" class="btn btn-link btn-sm">修改手机号</a>
				    	<#else>
				    	<a href="javascript:void(0)" data-target="#bangDing"  data-toggle="modal" class="btn btn-link btn-sm">绑定手机号</a>
				    	</#if>
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <div class="col-lg-offset-2 col-lg-6">
				      <input type="submit" class="btn btn-success btn-sm" value="保存"/>
				    </div>
				  </div>
				</form>
				
			</div>
		</div>
	</div>

   <#-- <#include "bindTel.ftl">-->
<div class="modal fade" id="bangDing" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">绑定手机号</h4>
            </div>
            <div class="modal-body">
                <form method="post"  action="${basepath}/account/saveSetting" id="telForm" name="telForm" class="form-horizontal">
                    <div class="form-group">
                        <label for="editPhone" class="col-lg-2 control-label">手机号：</label>
                        <div class="col-lg-6">
                        <#--data-rule="手机号:required;mobile" -->
                            <input name="editPhone" type="text" class="form-control" id="editPhone" value=""  placeholder="请输入手机号"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-2"></div>
                        <div class="col-lg-4">
                            <button class="btn btn-default" type="button" id='getCode'>获取验证码</button>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="codeValue" class="col-lg-2 control-label">验证码：</label>
                        <div class="col-lg-6">
                            <input name="codeValue" type="text" class="form-control" id="codeValue" value=""  placeholder="请输入验证码"/>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button id="editSubimt" type="button" class="btn btn-primary" type="submit">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script type="text/javascript" src="${basepath}/resource/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    $('form[name="telForm"]').validator({
        fields: {
            'editPhone': 'required;mobile;',
            'codeValue': 'required;valiCode;',
        }
    });

    $("#getCode").click(function () {
         $('form[name="telForm"]').validator({
            fields: {
                'editPhone': 'required;mobile;'
            }
        });
        if($("#telForm").isValid()){
            $(this).attr("disabled", "disabled");
            var _url = "getVliCode?phone="+$(this).val();
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
        }

    });
$(function() {
	//$("#birthday").addClass("form-control");
});
function changeProvince(){
	var selectVal = $("#province").val();
	if(!selectVal){
		console.log("return;");
		return;
	}
	var _url = "selectCitysByProvinceCode?provinceCode="+selectVal;
	console.log("_url="+_url);
	$("#citySelect").empty().append("<option value=''>--选择城市--</option>");
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
</script>
</@html.htmlBase>