<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="优惠券">
<style>
	.dfsfdsfsf label{
		display: inline;
	}
</style>

<form action="${basepath}/manage/discount" theme="simple" id="form" class="form-horizontal">
	<table class="table table-bordered">
		<tr>
			<td colspan="2" style="background-color: #dff0d8;text-align: center;">
				<strong>优惠券编辑</strong>
			</td>
		</tr>
		<tr style="display: none;">
			<td>id</td>
			<td><input type="hidden" value="${e.id!""}" name="id" label="id" id="id"/></td>
		</tr>
		<tr>
			<td style="text-align: right;width: 200px;">优惠券名称</td>
			<td style="text-align: left;">
				<input type="text" value="${e.name!""}" name="name" id="name" data-rule="优惠券名称:required;name;length[1~45];"/>
			</td>
		</tr>
        <tr>
            <td style="text-align: right;width: 200px;">发放总量</td>
            <td style="text-align: left;">
                <input type="text" value="${e.allcount!""}" name="allcount" id="allcount" data-rule="发放数量:required;integer;length[1~1000];"/>
            </td>
        </tr>
        <tr>
            <td style="text-align: right;width: 200px;">面值</td>
            <td style="text-align: left;">
                <input type="text" value="${e.facevale!""}" name="facevale" id="facevale" data-rule="面值:required;integer;length[0~1000];"/>
            </td>
        </tr>
        <tr>
            <td style="text-align: right;width: 200px;">订单金额</td>
            <td style="text-align: left;">是否限制至少消费金额
                <select id="cuttype" name="cuttype"  class="input-small">
                    <option value="0"  <#if e.cuttype?? && e.cuttype==0>selected="selected" </#if>>不限制</option>
                    <option value="1"  <#if e.cuttype?? && e.cuttype==0>selected="selected" </#if>>限制</option>
                </select>
                <input type="text" value="${e.cutnum!""}" name="cutnum" id="cutnum" data-rule="订单金额限制:required;integer;length[0~100000];"/>
            </td>
        </tr>
        <tr>
            <td style="text-align: right;">会员范围</td>
            <td style="text-align: left;" class="dfsfdsfsf" id="checkboxArr">
            <#--<%-->
            <#--application.setAttribute("accountRankMap",SystemManager.accountRankMap);-->
            <#--%>-->

                <select id="limget" name="limget"  class="input-small" data-rule="会员限制:required;">
                    <option value="0" <#if e.status?? && e.status==0>selected="selected" </#if>>不限制</option>
                    <option value="1" <#if e.status?? && e.status==1>selected="selected" </#if>>普通会员</option>
                    <option value="2" <#if e.status?? && e.status==2>selected="selected" </#if>>铜牌会员</option>
                    <option value="3" <#if e.status?? && e.status==3>selected="selected" </#if>>银牌会员</option>
                    <option value="4" <#if e.status?? && e.status==4>selected="selected" </#if>>金牌会员</option>
                    <option value="5" <#if e.status?? && e.status==5>selected="selected" </#if>>钻石会员</option>
                </select>
            </td>
        </tr>
        <tr>
            <td style="text-align: right;width: 200px;">每人限领</td>
            <td style="text-align: left;">
                <select id="limget" name="limget"  class="input-small" data-rule="每人限领:required;">
                        <option value="0" <#if e.status?? && e.status==0>selected="selected" </#if>>不限制</option>
                    <option value="1" <#if e.status?? && e.status==1>selected="selected" </#if>>限领1张</option>
                    <option value="2" <#if e.status?? && e.status==2>selected="selected" </#if>>限领1张</option>
                    <option value="3" <#if e.status?? && e.status==3>selected="selected" </#if>>限领3张</option>
                    <option value="5" <#if e.status?? && e.status==5>selected="selected" </#if>>限领5张</option>
                    <option value="10" <#if e.status?? && e.status==10>selected="selected" </#if>>限领10张</option>
                </select>
            </td>
        </tr>
		<tr>
			<td style="text-align: right;">生效时间</td>
			<td style="text-align: left;">
				<input id="begintime" class="Wdate search-query " type="text" name="begintime" style="height: 35px;"
				value="${e.begintime!""}" data-rule="生效时间:required;begintime;"
				onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d HH:mm:ss',maxDate:'#F{$dp.$D(\'endtime\')||\'2026-10-01\'}'})"/>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">过期时间</td>
			<td style="text-align: left;">
				<input id="endtime" class="Wdate search-query " type="text" name="endtime" style="height: 35px;"
				value="${e.endtime!""}" data-rule="过期时间:required;endtime;"
				onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'begintime\')}',maxDate:'2026-10-01'})"/>
			</td>
		</tr>
        <tr>
            <td style="text-align: right;">可用商品</td>
            <td style="text-align: left;">
                <input type="radio" name="protype" id="proType" value="0" checked>
            </td>
        </tr>
        <tr>
            <td style="text-align: right;width: 200px;">兑换金额</td>
            <td style="text-align: left;">

               <p><input type="radio" value="0" id="converttype" name="converttype"  class="input-small"  data-rule="checked"  <#if e.converttype?? && e.converttype==0>checked</#if>/>免费兑换</p>
                <p><input type="radio" value="1" id="converttype" name="converttype"  class="input-small"  data-rule="checked" <#if e.converttype?? && e.converttype==1>checked</#if>/>人民币兑换
                    <input type="text" value="${e.convertnum!""}" name="convertnum" id="convertnum" />元
                </p>
                <p><input type="radio" value="2" id="converttype" name="converttype"  class="input-small"   data-rule="checked" <#if e.converttype?? && e.converttype==2>checked</#if>/>燊活币兑换
                    <input type="text" value="${e.convertnum!""}" name="convertnum" id="convertnum" />币
                </p>
                <p><input type="radio" value="3" id="converttype" name="converttype"  class="input-small"  data-rule="checked"  <#if e.converttype?? && e.converttype==3>checked</#if>/>积分兑换
                    <input type="text" value="${e.convertnum!""}" name="convertnum" id="convertnum" />分
                </p>
            </td>
        </tr>
		<tr>
			<td style="text-align: right;">状态</td>
			<td style="text-align: left;">
                <select id="status" name="status"  class="input-small" data-rule="状态:required;status;">
                        <option value="0" <#if e.status?? && e.status==0>selected="selected" </#if>>失效</option>
                    <option value="1" <#if e.status?? && e.status==1>selected="selected" </#if>>生效</option>
                </select>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;" colspan="2">
				<#if e.id??>
                    <button method="update" class="btn btn-success">
                        <i class="icon-ok icon-white"></i> 保存
                    </button>
				<#else>
                    <button method="insert" class="btn btn-success">
                        <i class="icon-ok icon-white"></i> 新增
                    </button>
				</#if>
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript">
$(function(){
    $("#cutnum").val("0");
});

</script>
</@page.pageBase>