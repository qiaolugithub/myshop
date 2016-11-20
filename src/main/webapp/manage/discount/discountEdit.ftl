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
                    <option value="1"  <#if e.cuttype?? && e.cuttype==1>selected="selected" </#if>>限制</option>
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
                    <option value="2" <#if e.status?? && e.status==2>selected="selected" </#if>>限领2张</option>
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
                <p> <input type="radio" name="protype" id="protype_0" value="0" data-rule="checked"  <#if e.protype?? && e.protype==0>checked</#if>/>全部商品全部分类</p>
                <p> <input type="radio" name="protype" id="protype_1" value="1" data-rule="checked"  <#if e.protype?? && e.protype==1>checked</#if>/>指定分类(如果选择父分类则包含下属子分类)
                <input type="text" name="proid" id="proid_1" value="${e.proid!""}"  placeholder="商品分类按照逗号分隔">商品分类按照逗号分隔0默认所有
                </p>
                <p> <input type="radio" name="protype" id="protype_2" value="2" data-rule="checked"  <#if e.protype?? && e.protype==2>checked</#if>/ >指定商品
                <input type="text" name="proid" id="proid_2" value="${e.proid!""}" placeholder="商品按照逗号分隔">商品按照逗号分隔0默认所有
                </p>
            </td>
        </tr>
        <tr>
            <td style="text-align: right;width: 200px;">兑换金额</td>
            <td style="text-align: left;">

               <p><input type="radio" value="0" id="converttype_0" name="converttype"  class="input-small"  data-rule="checked"  <#if e.converttype?? && e.converttype==0>checked</#if>/>免费兑换</p>
                <p><input type="radio" value="1" id="converttype_1" name="converttype"  class="input-small"  data-rule="checked" <#if e.converttype?? && e.converttype==1>checked</#if>/>人民币兑换
                    <input type="text" value="${e.convertnum!""}" id="convertnum_1" name="convertnum" id="convertnum" />元
                </p>
                <p><input type="radio" value="2" id="converttype_2" name="converttype"  class="input-small"   data-rule="checked" <#if e.converttype?? && e.converttype==2>checked</#if>/>燊活币兑换
                    <input type="text" value="${e.convertnum!""}" id="convertnum_2" name="convertnum" id="convertnum" />币
                </p>
                <p><input type="radio" value="3" id="converttype_3" name="converttype"  class="input-small"  data-rule="checked"  <#if e.converttype?? && e.converttype==3>checked</#if>/>积分兑换
                    <input type="text" value="${e.convertnum!""}" id="convertnum_3" name="convertnum" id="convertnum" />分
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
    $("#proid_1").val("0");
    $("#proid_2").val("0");
    $("#convertnum_1").val("0");
    $("#convertnum_2").val("0");
    $("#convertnum_3").val("0");
});
/*
$('#form').validator({
    rules: {
        isprotype_1: function(element) {
            // 返回true，则验证必填
            return $("#protype_1").is(":checked");
        }
    },
    fields: {
        proid: 'required(isprotype_1); proid'
    }
});*/
/*

$("#form").on("validation", function(e, current){
  // 表单全部字段验证通过则返回 true
  // 只要有一个字段验证不通过就返回 false
  // 还没验证完，即验证结果未知的情况下返回 undefined
  console.log(this.isValid);
      // 当前正在验证的字段是否通过
       console.log(current.isValid);

    if( $("#protype_1").is(":checked")&& $("#proid_1").val()=="") {
        alert("请输入商品id");
        return false;
    }
})
*/


</script>
</@page.pageBase>