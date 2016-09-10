<!-- Modal -->
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
                        <div class="col-lg-4">
                            <button class="btn btn-default" type="button" id='getCode'>获取验证码</button>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="codeValue" class="col-lg-2 control-label">验证码：</label>
                        <div class="col-lg-6">
                            <input name="codeValue" type="text" class="form-control" id="codeValue" value="" data-rule="验证码:required;valiCode" placeholder="请输入验证码"/>
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
<script type="text/javascript">
    $().ready(function() {
        $('form[name="telForm"]').validator({
            fields: {
                'editPhone': 'required;mobile;'
            }
        });
    });



    //点击弹窗执行 初始化
    $("#bangDing").click(function(){
        $("#editPhone").val("");
        $("#codeValue").val("");
    });



</script>