<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="燊活币管理">
<form action="${basepath}/manage/lifecoin"  namespace="/manage"  method="post" theme="simple">
    <table class="table table-bordered">
        <tr>
            <td style="text-align: right;">账号</td>
            <td style="text-align: left;" ><input type="text"  value="${e.account!""}" name="account"  class="input-small"
                                                  id="name" /></td>
            <td style="text-align: right;">电话</td>
            <td style="text-align: left;" ><input type="text"  value="${e.tel!""}" name="tel"  class="input-small"
                                                  id="name" /></td>
            <!-- 						<td style="text-align: right;">录入人</td> -->
            <td colspan="8">
            <#--<%-- 					<s:submit method="selectList" value="查询" cssClass="btn btn-primary"/> --%>-->
                <a href="selectList" class="btn btn-primary">
                    <i class="icon-search icon-white" ></i> 查询
                </a>
            </td>
            <td>总生活币：<a class="font-focus" href="javacript;">${sum!""}</a></td>
            <td>账户数：<a class="font-focus" href="javacript;">${count!""}</a></td>

            <#--<%-- 					<s:submit method="toAdd" value="添加" cssClass="btn btn-success" /> --%>-->
            <#--<%-- 					<s:submit method="deletes" onclick="return deleteSelect();" value="删除" cssClass="btn btn-danger" /> --%>-->

                <div style="float: right;vertical-align: middle;bottom: 0px;top: 10px;">
                    <#include "/manage/system/pager.ftl"/>
                </div>
            </td>
        </tr>
    </table>

    <table class="table table-bordered table-hover">
            <tr style="background-color: #dff0d8">
                <th style="text-align: center;">昵称</th>
                <th style="text-align: center;">手机号</th>
                <th style="text-align: center;">生活币</th>
                <th style="text-align: center;">生活币地址</th>
             <#--   <th style="text-align: center;">操作</th>-->
            </tr>
        <#list pager.list as item>
                <tr>
                    <td style="display: none;">${item.id!""}</td>
                    <td style="text-align: center;">
                    ${item.account!""}
                    </td>
                    <td style="text-align: center;">${item.tel!""}</td>
                    <td style="text-align: center;">${item.coincount!""}</td>
                    <td style="text-align: center;">${item.coinaddress!""}</td>
                  <#--  <td nowrap="nowrap" style="text-align: center;">
                        <a href="toEdit?id=${item.id}">编辑</a>
                    </td>-->
                </tr>
        </#list>
        <tr>
            <td colspan="16" style="text-align: center;">
                <#include "/manage/system/pager.ftl"/></td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    $(function() {
        function c1(f) {
            $(":checkbox").each(function() {
                $(this).attr("checked", f);
            });
        }
        $("#firstCheckbox").click(function() {
            if ($(this).attr("checked")) {
                c1(true);
            } else {
                c1(false);
            }
        });

    });
    function deleteSelect() {
        if ($("input:checked").size() == 0) {
            return false;
        }
        return confirm("确定删除选择的记录?");
    }
</script>
</@page.pageBase>