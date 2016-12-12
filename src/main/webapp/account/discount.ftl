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
                            <th style="text-align: center;">限购分类或商品</th>
                            <th style="text-align: center;">状态</th>
                            <th style="text-align: center;">操作</th>
                        </tr>
                        <#list discountList as item>
                            <tr>
                                <td style="display: none;">${item.id!""}</td>
                                <td style="text-align: center;">${item.name!""}
                                </td>
                                <td style="text-align: center;">
                                     <#if item.cuttype?? && item.cuttype==0>
                                           不限制
                                         <#else>
                                         <#if item.cutnum??>
                                            满${item.cutnum!""}元减
                                         </#if>
                                     </#if>
                                     </td>
                                <td style="text-align: center;">${item.facevale!""}</td>
                                <td style="text-align: center;">${item.begintime!""}到${item.endtime!""}</td>
                                <td style="text-align: center;">
                                ${item.pname!""}
                                        <#-- <#if item.protype?? && item.protype=="0" && item.proid?? && item.proid=="0">
                                             全部商品
                                        <#elseif  item.protype?? && item.protype=="1"  && item.proid?? && item.proid!="0">
                                            指定分类
                                         <#elseif  item.protype?? && item.protype=="2"  && item.proid?? && item.proid!="0">
                                             指定商品
                                         <#else>
                                             状态异常
                                     </#if>-->
                                </td>
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
                                    <#elseif  item.canuse?? && item.canuse =="1" >
                                       <a href="${basepath}/index"> 立即使用</a>
                                        <#else>
                                           不可使用
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
                            <th style="text-align: center;">限购分类或商品</th>
                            <th style="text-align: center;">兑换金额</th>
                          <#--  <th style="text-align: center;">状态</th>-->
                            <th style="text-align: center;">操作</th>
                        </tr>
                        <#list discountList2 as item>
                            <tr>
                                <td style="display: none;">${item.id!""}</td>
                                <td style="text-align: center;">${item.name!""}
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
                                <td style="text-align: center;">  ${item.pname!""}
                                  <#--  <#if item.protype?? && item.protype=="0" && item.proid?? && item.proid=="0">
                                        全部商品
                                    <#elseif  item.protype?? && item.protype=="1"  && item.proid?? && item.proid!="0">
                                        指定分类
                                    <#elseif  item.protype?? && item.protype=="2"  && item.proid?? && item.proid!="0">
                                        指定商品
                                    <#else>
                                        状态异常
                                    </#if>-->
                                </td>
                                <td style="text-align: center;">
                                     <#if  item.converttype?? && item.converttype ==1 >
                                            ${item.convertnum!""}元
                                     <#elseif  item.converttype?? && item.converttype ==2 >
                                         ${item.convertnum!""}燊活币
                                     <#elseif  item.converttype?? && item.converttype ==3 >
                                        ${item.convertnum!""}积分
                                     <#elseif item.converttype?? && item.converttype ==0 >
                                         免费领取
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
                                     <#if item.overTime==1>
                                         已过期
                                     <#elseif item.converttype?? && item.converttype ==0 && item.isGet ==0>
                                        <a class="getDiscount" val="${item.id!""}">领用</a>
                                    <#elseif item.converttype?? && item.converttype !=0 && item.isGet ==0>
                                        <a href="${basepath}/discount/toChange?id=${item.id!""}" >兑换</a>
                                     <#elseif item.isGet?? && item.isGet ==1 >
                                         已领取(<a class="getDiscount" val="${item.id!""}">再次领用</a>)
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
    var path = $("#path").val();
    $(".getDiscount").click(function () {
        $.ajax({
            type: 'POST',
            url:path+ "/discount/getDiscount?id="+$(this).attr("val"),
            dataType: "text",
            success: function(data){
                if(data=="error"){
                  BootstrapDialog.confirm({
                        title: '异常',
                        message: "数据异常",
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
                }else if(data=="count"){
                     BootstrapDialog.confirm({
                        title: '您已经领取过了',
                        message: "您已经领取过了",
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
                                location.reload();
                            }
                        }
                    });
                }
            },
            error:function(er){
            }
        });
    });

    $("#toChange").click(function () {
        $.ajax({
            type: 'POST',
            url:path+ "/discount/toChange?id="+$(this).attr("val"),
            success: function(data){
            },
            error:function(er){
            }
        });
    });
</script>
</@html.htmlBase>