<#import "/resource/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>

<@html.htmlBase title="优惠券减免支付">
    <@menu.menu selectMenu=""/>
<h1>优惠券已减免支付，直接确认即可！</h1>
<h3>订单信息</h3>
<table class="table">
    <tr>
        <td>订单号:</td>
        <td>${payInfo.WIDout_trade_no!""}</td>
    </tr>
    <tr>
        <td>标题:</td>
        <td>${payInfo.WIDsubject!""}</td>
    </tr>
    <tr>
        <td>金额:</td>
        <td>${payInfo.WIDprice!""}</td>
    </tr>
    <tr>
        <td>配送费:</td>
        <td>${payInfo.logistics_fee!""}</td>
    </tr>
</table>
<div> <input id="btnPay" type="button" class="btn btn-primary" style="margin-left: 250px" value="确认支付"/></div>

<script>
    $(function(){
        $("#btnPay").click(function(){
            if(confirm("确认支付?")) {
                $.ajax({
                    dataType:"json",
                    url:"${basepath}/paygate/dummyPay",
                    type:"POST",
                    data:{orderId:"${payInfo.WIDout_trade_no}"},
                    success:function(data){
                        window.location.href="${basepath}/order/paySuccess.html";
                    },
                    error:function(data){
                        alert("支付失败");
                    }
                });
            }
        });
    })
</script>
</@html.htmlBase>