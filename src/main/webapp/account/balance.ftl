<#import "/resource/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>
<#import "/account/accountMenu.ftl" as accountMenu>
<@html.htmlBase>
	<@menu.menu selectMenu=""/>
	<div class="container">
		<div class="row">
			<div class="col-xs-3">
				<@accountMenu.accountMenu currentMenu="balance"/>
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
                <a href="javascript:void(0)" data-target="#bangDing"  data-toggle="modal" class="btn btn-link btn-sm">修改手机号</a>

		</div>
	</div>

        <div class="modal fade" id="bangDing" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">绑定手机号</h4>
                    </div>
                    <div class="modal-body">
                        <form id="signupForm" name="signupForm">
                            <div class="form-group">
                                <label for="editPhone" class="col-lg-2 control-label">手机号：</label>
                                <div class="col-lg-6">
                                    <input name="editPhone" type="text" class="form-control" id="editPhone" value="" data-rule="手机号:required;mobile" placeholder="请输入手机号"/>
                                </div>
                            <#--   <input type="password" name="demo" data-rule="required;xxx" data-rule-xxx="[/^\d{6}$/, '请输入6位数字']">
                               <input name="editPhone" type="text" class="form-control" id="editPhone" value=""  data-rule="验证码:required;valiCode" placeholder="请输入手机号"/>-->
                        </form>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button id="editSubimt" type="button" class="btn btn-primary" type="submit">保存</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
<script type="text/javascript">
    $().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
     /*   $("#signupForm").validate({
            rules: {
                editPhone: {
                    required: true,
                    minlength: 2
                }
            },
            messages: {
                editPhone: {
                    required: "请输入用户名",
                    minlength: "用户名必需由两个字母组成"
                }
            }
        });
*/
        $('form[name="signupForm"]').validator({
            fields: {
                'editPhone': 'required;email;'
            }
        });
    });


/*
	$("#editSubimt").click(function(){
		*//*$("#yourForm").validator({
		    rules: {
		        xxx: [/^\d{6}$/, '请输入6位数字']
		    },
		    fields: {
		        demo: {
		            rule: "required; xxx",
		            msg: {required: "请填写密码"},
		            tip: "密码由6位数字组成",
		            ok: "别担心，稍后您还可以更改",
		            target: "#msg_holder"
		        }
		    }
		});*//*
});*/
</script>
</@html.htmlBase>