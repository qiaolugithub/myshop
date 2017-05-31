<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="优惠券管理">
<form action="${basepath}/manage/discount"  namespace="/manage"  method="post" theme="simple">
    <table class="table table-bordered">
        <tr>
            <td colspan="8">
            <#--<%-- 					<s:submit method="selectList" value="查询" cssClass="btn btn-primary"/> --%>-->
                <a href="selectList" class="btn btn-primary">
                    <i class="icon-search icon-white"></i> 查询
                </a>

                <a href="toAdd" class="btn btn-success">
                    <i class="icon-plus-sign icon-white"></i> 添加
                </a>

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
                <th style="text-align: center;">优惠券名称</th>
              <#--  <th style="text-align: center;">使用条件</th>-->
                <th style="text-align: center;">面值</th>
                <th style="text-align: center;">有效期</th>
                <th style="text-align: center;">是否过期</th>
                <th style="text-align: center;">限购商品</th>
                <th style="text-align: center;">领取数量（剩余/总数）</th>
                <th style="text-align: center;">兑换金额</th>
                <th style="text-align: center;">状态</th>
                <th style="text-align: center;">操作</th>
            </tr>
        <#list pager.list as item>
                <tr>
                    <td style="display: none;">${item.id!""}</td>
                    <td style="text-align: center;">
                    ${item.name!""}
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
                 -->
                    <td style="text-align: center;">${item.facevale!""}</td>
                    <td style="text-align: center;">${item.begintime!""}到${item.endtime!""}</td>
                    <td nowrap="nowrap" style="text-align: center;">
                    <#if item.overTime==1>
                        已过期
                    <#else>
                        未过期
                    </#if>
                    </td>
                    <td style="text-align: center;">${item.pname!""}</td>
                    <td style="text-align: center;">${item.levcount!""}/${item.allcount!""}</td>
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
                    <td nowrap="nowrap" style="text-align: center;">
                        <#if item.status ?? && item.status ==0 >
                            不可用
                        <#elseif item.status?? && item.status !=0 >
                            可用
                        <#else>
                            异常数据
                        </#if>
                    </td>
                    <td nowrap="nowrap" style="text-align: center;">
                        <a href="toEdit?id=${item.id}">编辑</a>
                        <a href="javascript:void(0)" data-target="#sendgeren" value="${item.id}"  data-toggle="modal" class="btn btn-link btn-sm sendGR">发送给个人</a>
                    </td>
                </tr>
        </#list>
        <tr>
            <td colspan="16" style="text-align: center;">
                <#include "/manage/system/pager.ftl"/></td>
        </tr>
    </table>
</form>


<#-- <#include "bindTel.ftl">-->
<div class="modal fade" id="sendgeren" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">发送个人</h4>
            </div>
            <div class="modal-body">
                    <input name="discountId" type="hidden" class="form-control" id="discountId" value="" />
                    <div class="form-group" style="height:30px">
                        <label class="col-lg-6 control-label">用户名（账号，不要输入昵称）：</label>
                        <div class="col-lg-6">
                            <input name="user" type="text" class="form-control" id="user" value=""  placeholder="请输入用户"/>
                        </div>
                    </div>
            </div>
            <div class="modal-footer">
                <button type="button" id="cancelBtn" class="btn btn-default" data-dismiss="modal">取消</button>
                <button id="editSubimt" type="button" class="btn btn-primary" type="button">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script type="text/javascript">
    $(".sendGR").on("click",function () {
        $("#discountId").val( $(this).attr("value"));
    });


    $("#editSubimt").on("click", function () {
       var user = $("#user").val();
        var disId = $("#discountId").val();

        var _url = "bindDiscount";
        $.ajax({
            type: 'POST',
            url: _url,
            data: {user:user,disId:disId},
            dataType: "text",
            success: function (data) {
                alert(data);
            },
            error: function (err) {
                alert("失败");
            }
        });
    });

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

    function deleteSelect() {
        if ($("input:checked").size() == 0) {
            return false;
        }
        return confirm("确定删除选择的记录?");
    }
</script>
</@page.pageBase>