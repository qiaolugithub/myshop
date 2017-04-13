<#import "/resource/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>
<#import "/account/accountMenu.ftl" as accountMenu>
<@html.htmlBase>
<style type="text/css">
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
                        <li class="active">兑换优惠券</li>
                    </ol>
                </div>
            </div>

            <hr>
            <div class="row">
                <div class="list-group">
                    <a  class="list-group-item disabled">
                        优惠券名称:${discount.name!""}
                    </a>
                    <a  class="list-group-item">
                        优惠券面值:${discount.facevale!""}元
                    </a>
                    <a  class="list-group-item">
                        限制的商品或者分类:${discount.pname!""}</a>
                    <a  class="list-group-item">
                        使用时间：${discount.begintime!""}到${discount.endtime!""}
                    </a>
                    <a  class="list-group-item" id="payNum">
                        <#if  discount.converttype?? && discount.converttype ==1 >
                        ${discount.convertnum!""}元
                        <#elseif  discount.converttype?? && discount.converttype ==2 >
                        ${discount.convertnum!""}燊活币
                        <#elseif  discount.converttype?? && discount.converttype ==3 >
                        ${discount.convertnum!""}积分
                    </#if>
                    </a>

                    <a  class="list-group-item">
                        <button id="duihuan" type="button" class="btn btn-primary" val="${discount.id}">确定兑换</button> <button type="button" class="btn btn-link" onClick="javascript :history.back(-1);">返回</button>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var path = $("#path").val();
    $("#duihuan").click(function () {
        BootstrapDialog.confirm({
            title: '确定兑换',
            message: "确定要花费"+$("#payNum").html()+"兑换此优惠券？",
            type: BootstrapDialog.TYPE_DANGER,
            closable: true,
            btnCancelLabel: '取消',
            btnOKLabel: '确认',
            btnOKClass: 'btn-danger',
            callback: function (result) {
                if (result) {
                    $.ajax({
                        type: 'POST',
                        url:path+ "/discount/payDiscount?id="+$("#duihuan").attr("val"),
                        dataType: "text",
                        success: function(data){
                            if(data!="success"){
                                BootstrapDialog.confirm({
                                    title: '兑换失败',
                                    message:data,
                                    type: BootstrapDialog.TYPE_DANGER,
                                    closable: true,
                                    btnCancelLabel: '取消',
                                    btnOKLabel: '确认',
                                    btnOKClass: 'btn-danger',
                                    callback: function (result) {
                                        if (result) {
                                        }
                                    }
                                });
                            } else if(data=="success"){
                                BootstrapDialog.confirm({
                                    title: '免费抢卷',
                                    message: " 领取成功！感谢您的参与，祝您购物愉快~本活动为概率性事件，不能保证所有客户成功领取优惠",
                                    type: BootstrapDialog.TYPE_DANGER,
                                    closable: true,
                                    btnCancelLabel: '取消',
                                    btnOKLabel: '确认',
                                    btnOKClass: 'btn-danger',
                                    callback: function (result) {
                                        if (result) {
                                            window.location = "${basepath}/account/discount";
                                        }
                                    }
                                });
                            }
                        },
                        error:function(er){
                        }
                    });
                }
            }
        });
    });


</script>
</@html.htmlBase>