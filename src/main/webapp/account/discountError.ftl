<#import "/resource/common_html_front.ftl" as html>
<#import "/indexMenu.ftl" as menu>
<#import "/account/accountMenu.ftl" as accountMenu>
<@html.htmlBase>
<style type="text/css">
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
                        <li class="active">兑换优惠券</li>
                    </ol>
                </div>
            </div>

            <hr>
            <div class="row">
                    <div class="bs-callout bs-callout-danger author" style="text-align: left;font-size: 14px;margin: 2px 0px;">
                    ${msg!""}
                    </div>
            </div>
        </div>
    </div>
</div>
</@html.htmlBase>