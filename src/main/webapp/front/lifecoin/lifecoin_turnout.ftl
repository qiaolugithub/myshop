<#import "/resource/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>
<#import "/account/accountMenu.ftl" as accountMenu>
<@html.htmlBase>
    <@menu.menu selectMenu=""/>
<div class="container">
    <div class="row">
        <div class="col-xs-3">
            <@accountMenu.accountMenu currentMenu="lifecoin"/>
        </div>

        <div class="col-xs-8">
            <h3>燊活币转出:</h3>
            <#if  msg??>
                <h4>${msg}</h4>
                <a  class="btn btn-primary btn-sm"  href="${basepath}/account/lifecoin" >返回上一页</a>
            <#else>
            <#if  isCheck==false>
                <h4>您上次的一笔交易还没达到三次确认请等待三次确认后进行操作！</h4>
            <#else>


                    <form action="${basepath}/front/lifecoin/sendlifeCoin"  namespace="/manage"  method="post" theme="simple">
                <table class="table table-bordered"  >
                    <input id="accountid" name="accountid" value="${accountid}" type="hidden"/>
                    <tr>
                        <td style="text-align: right;">转出地址</td>
                        <td style="text-align: left;" ><input id="address" name="address" value=""  type="text"
                                      class="form-control"   data-rule="转出地址:required;length[30~38];" placeholder="请输入转出地址" maxlength="38" size="38"></td>
                    </tr>
                    <tr>
                        <td style="text-align: right;">转出金额</td>
                        <td style="text-align: left;" ><input id="num" name="num" value=""  type="text"
                          class="form-control"  data-rule="转出金额;required;price;" size="20"   placeholder="请输入转出金额" maxlength="20"    ></td>
                    </tr>

                   <#-- <tr>
                        <td style="text-align: right;">验证码</td>
                        <td style="text-align: left;" >${lifeCoin.coincount!""}</td>
                    </tr>
                     -->


                </table>
                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-6">
                        <button type="button"  class="btn btn-primary btn-sm"  onclick="javascript:history.back(-1);" >返回上一页</button>

                        <button type="submit" class="btn btn-success btn-sm" value="保存">
                            <span class="glyphicon glyphicon-ok"></span>&nbsp;保存
                        </button>
                    </div>
                </div>
            </form>
            </#if>
            </#if>
        </div>
    </div>


    <script type="text/javascript">
        $().ready(function () {

        });
    </script>
</@html.htmlBase>
<#--
<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="燊活币管理">

<form action="${basepath}/manage/lifecoin"  namespace="/manage"  method="post" theme="simple">
    <table class="table table-bordered">
        <input id="id" name="id" value="${lifeCoin.id}" type="hidden"/>
        <input id="accountid" name="accountid" value="${accountid}" type="hidden"/>
        <tr>
            <td style="text-align: right;">昵称</td>
            <td style="text-align: left;" >${account.account}/${account.nickname}</td>
        </tr>
        <tr>
            <td style="text-align: right;">电话</td>
            <td style="text-align: left;" >${account.tel!""}</td>
        </tr>
        <tr>
            <td style="text-align: right;">地址</td>
            <td style="text-align: left;" >${lifeCoin.coinaddress!""}</td>
        </tr>
        <tr>
            <td style="text-align: right;">余额</td>
            <td style="text-align: left;" >${lifeCoin.coincount!""}</td>
        </tr>
        <tr>
            <td style="text-align: right;">锁定账户</td>
            <td style="text-align: left;" >
                <p> <input type="radio" name="islock" id="islock_0" value="0" data-rule="checked"  <#if lifeCoin.islock?? && lifeCoin.islock==0>checked</#if>/>未锁定</p>
                <p> <input type="radio" name="islock" id="islock_1" value="1" data-rule="checked"  <#if lifeCoin.islock?? && lifeCoin.islock==1>checked</#if>/>锁定账户</p>
            </td>
        </tr>
        <tr>
            <td style="text-align: right;">备注</td>
            <td style="text-align: left;" ><textarea style="width: 500px;height: 50px" id="remark" name="remark">${lifeCoin.remark!""}</textarea></td>
        </tr>
        <button type="button"  class="btn btn-primary"  onclick="javascript:history.back(-1);" >返回上一页</button>

        <button method="saveUserLifeCoin" class="btn btn-primary" ">
            <i class="icon-search icon-white"></i> 保存
        </button>
    </table>

    <table class="table table-bordered table-hover">
            <tr style="background-color: #dff0d8">
                <th style="text-align: center;">时间</th>
                <th style="text-align: center;">操作类型</th>
                <th style="text-align: center;">生活币</th>
                <th style="text-align: center;">地址</th>
                <th style="text-align: center;">确认项</th>
            </tr>
        <#list pager.list as item>
                <tr>
                    <td style="text-align: center;">${item.time?string("yyyy-MM-dd HH:mm:ss")}</td>
                    <td style="text-align: center;">
                        <#if item.category ?? && item.category =="receive" >
                            接收
                        <#elseif item.category?? && item.category =="generate" >
                            挖矿
                        <#elseif item.category?? && item.category =="send" >
                            发送
                        <#else>
                            其他
                        </#if>
                    </td>
                    <td style="text-align: center;">${item.amount!""}</td>
                    <td style="text-align: center;">${item.address!""}</td>
                    <td style="text-align: center;">${item.confirmations!""}</td>
                </tr>
        </#list>
        <tr>
         &lt;#&ndash;   <td colspan="16" style="text-align: center;">
                <#include "/manage/system/pager.ftl"/></td>&ndash;&gt;
        </tr>
    </table>
</form>
</@page.pageBase>-->
