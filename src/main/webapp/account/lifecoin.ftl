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
                    <div class="alert alert-success" role="alert">
                        可用燊活币:<span style="color: red;font-weight: bold">
                            <#if coinNum??>${coinNum}
                            <#else>0
                            </#if>
                            </span>
                            <span  style="color: #000000;font-weight: bold">
                            SHP </span>

                            <#if isLock?? && isLock==1>  <span style="color: #000000;font-weight: bold">
                            账户已被锁，请联系客服或者管理员 </span></#if>
        <#if coinNum?? && (coinNum>0)>
                            <a class="btn btn-default btn-sm" href="${basepath}/front/lifecoin/turnOut">转出</a>
        </#if>
                    </div>
                </div>
                <h3>燊活币充值:</h3>
                <h4>请将虚拟币转至如下地址：</h4>
<#--
                <#list lifeAddress as item>
                       <span class="text-center"><h4 style="color:blue">${item}</h4></span>
                </#list>-->

                <span class="text-center"><h4 style="color:blue">${lifeAddress}</h4></span>
                <h4 style="color:red">重要提示：本站已经支持往同一地址多次充值，我们将在收到3次确认以后为您充值成功。</h4>

                <hr>

                <#if pager.list??>
                    <table class="table table-bordered table-hover" style="margin-bottom: 10px;">
                        <tr style="background-color: #dff0d8">
                            <th style="text-align: center;">时间</th>
                            <th style="text-align: center;">交易的地址</th>
                            <th style="text-align: center;">交易类型</th>
                            <th style="text-align: center;">金额</th>
                         <#--   <th style="text-align: center;">网络费用</th>-->
                            <th style="text-align: center;">确认状态</th>
                        </tr>
                        <#list pager.list as item>
                                <tr>
                                <td style="text-align: center;">${item.time?string("yyyy.MM.dd HH:mm:ss")!''}</td>
                                <td style="text-align: center;">${item.address}</td>
                                <td style="text-align: center;">
                                 <#if  item.category=="send">
                                   发送
                                 <#elseif item.category=="receive">
                                 接收
                                 <#elseif item.category=="generate">
                                  挖矿
                                 <#else>
                                    异常数据
                                </#if>
                                </td>
                                <td style="text-align: center;">${item.amount}</td>
                               <#-- <td style="text-align: center;">${item.fee}</td>-->
                                <td style="text-align: center;">${item.confirmations}/3</td>
                            </tr>
                        </#list>
                    </table>
                    <div style="text-align: right;">
                        <#include "/pager.ftl"/>
                    </div>
                <#else>


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

                </#if>

            </div>
	</div>


<script type="text/javascript">
    $().ready(function () {

    });
</script>
</@html.htmlBase>