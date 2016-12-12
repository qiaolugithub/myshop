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
			
			<div class="col-xs-9">

                <div class="row">
                    <div class="col-xs-12">
                        <ol class="breadcrumb">
                            <li class="active">我的燊活币</li>
                        </ol>
                    </div>
                    <div class="alert alert-success" role="alert">可用生活币:<span style="color: red;font-weight: bold">
                        <#if coinNum??>${coinNum}
                        <#else>0
                        </#if>
                        </span>
                        <span style="color: #000000;font-weight: bold">
                        SHP </span>
                    </div>
                </div>
                <h3>生活币充值:</h3>
                <h4>请将虚拟币转至如下地址：</h4>
<#--
                <#list lifeAddress as item>
                       <span class="text-center"><h4 style="color:blue">${item}</h4></span>
                </#list>-->

                <span class="text-center"><h4 style="color:blue">${lifeAddress}</h4></span>
                <h4 style="color:red">重要提示：本站已经支持往同一地址多次充值，我们将在收到3次确认以后为您充值成功。</h4>

                <hr>

           <#--     <#if pager.list??>
                    <table class="table table-bordered table-hover" style="margin-bottom: 10px;">
                        <tr style="background-color: #dff0d8">
                            <th style="text-align: center;">时间</th>
                            <th style="text-align: center;">存入</th>
                            <th style="text-align: center;">支出</th>
                            <th style="text-align: center;">详细</th>
                        </tr>
                        <#list pager.list as item>
                            <tr>
                                <td style="text-align: center;">${item.createTime!""}</td>
                                <td style="text-align: left;">${item.depositNum!""}${item.depositNum}</td>
                                <td style="text-align: left;">${item.payNum!""}${item.payNum}</td>
                                <td style="text-align: center;">
                                 <#if item.type?? && item.type==1>
                                    钱包地址：${item.tonum!""}
                                 <#elseif item.type?? && item.type==2>
                                    订单号：<a href="">${item.tonum!""}</a>
                                 <#elseif item.type?? && item.type==3>
                                     优惠券：<a href="${item.tonum!""}">查看</a>
                                 <#else>
                                    异常数据
                                </#if>
                                </td>
                            </tr>
                        </#list>
                    </table>
                    <div style="text-align: right;">
                        <#include "/pager.ftl"/>
                    </div>
                <#else>
                    <!--
                    <div class="bs-callout bs-callout-danger author" style="text-align: left;font-size: 14px;margin: 2px 0px;">
                        还没有任何配送信息！赶紧添加吧。
                    </div>
                     &ndash;&gt;

                    <div class="col-xs-12">
                        <hr>
                        <div class="row">
                            <div class="col-xs-12" style="font-size: 14px;font-weight: normal;">
                                <div class="panel panel-default">
                                    <div class="panel-body" style="font-size: 16px;font-weight: normal;text-align: center;">
                                        <div class="panel-body" style="font-size: 16px;font-weight: normal;text-align: center;">
                                            <span class="glyphicon glyphicon-user"></span>亲，还没有任何交易记录。
                                        </div>
                                    </div>
                                </div>
                                <hr>
                            </div>
                        </div>

                    </div>

                </#if>-->

            </div>
	</div>


<script type="text/javascript">
    $().ready(function () {

    });
</script>
</@html.htmlBase>