<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="燊活币管理">
<form action="${basepath}/manage/lifecoin"  namespace="/manage"  method="post" theme="simple">
    <table class="table table-bordered">
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
            <td style="text-align: left;" >${lifeCoin.address!""}</td>
        </tr>

    </table>

    <table class="table table-bordered table-hover">
            <tr style="background-color: #dff0d8">
                <th style="text-align: center;">生活币</th>
                <th style="text-align: center;">生活币地址</th>
            </tr>
        <#list pager.list as item>
                <tr>
                    <td style="text-align: center;">${item.coincount!""}</td>
                    <td style="text-align: center;">${item.coinaddress!""}</td>
                </tr>
        </#list>
        <tr>
         <#--   <td colspan="16" style="text-align: center;">
                <#include "/manage/system/pager.ftl"/></td>-->
        </tr>
    </table>
</form>
</@page.pageBase>