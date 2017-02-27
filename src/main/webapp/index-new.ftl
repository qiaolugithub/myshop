<#import "/resource/common_html_front.ftl" as html/>
<@html.htmlBase>
<head>
<meta property="qc:admins" content="50702666757625530706654" />
<meta property="wb:webmaster" content="28e244326adb6a77" />

    <link rel="stylesheet" href="${basepath}/resource/css/base-new.css"  type="text/css">
</head>

<body>
<div class="nav_wrap clearfix">
    <div class="lf nav_logo"  ><a ><img class="img_w100" src="${systemSetting().log}"></a></div>
    <div class="lf nav_content">
        <div class="top_nav_wrap clearfix">
            <div class="lf search_wrap">
                <form  role="form" name="searchForm" id="searchForm" method="post"
                       action="${basepath}/search.html">
                    <div class="search_detail">
                        <input type="text" name="key" id="key" placeholder="请输入商品关键字" size="40" value="${key!""}" maxlength="20"/>
                        <span class="com_icon" id="searchBtn"></span>
                    </div>
                <#--todo-->
                <#-- <a class="btn btn-success btn-sm" href="${basepath}/cart/cart.html">
                     <span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;购物车
                     <#if shoppingCart()?? && shoppingCart().productList?? && shoppingCart().productList?size gt 0>
                         <span class="badge badge-success">${shoppingCart().productList?size}</span>
                     </#if>
                 </a>-->
                </form>
                <p><span>热门搜索：</span>
                <#list systemManager().hotqueryList as item>
                    <a class="hotSearch" href="${item.url}" target="_blank">
                    ${item.key1!""}
                    </a>
                </#list>
                </p>
            </div>
            <div class="rf full_cut">
            <#--<#if currentAccount()??>
              <span id="myshopMenuPPP" style="display: inline-block;z-index: 9999;position: relative;;">
                        <span style="margin-top: 0px;">
                        <a data-toggle="dropdown" style="display: block;margin-top: 0px;">
                            <span class="glyphicon glyphicon-user"></span>&nbsp;用户中心
                            (${currentAccount().nickname})
                            <span class="caret" style="display: inline-block;"></span>
                        </a>
                        <ul class="dropdown-menu" id="myshopMenu" role="menu" style="display: none;margin-top: 0px;">
                            <li><a href="${basepath}/account/account"><span class="glyphicon glyphicon-user"></span>&nbsp;个人资料</a></li>
                            <li><a href="${basepath}/account/topwd"><span class="glyphicon glyphicon-screenshot"></span>&nbsp;修改密码</a></li>
                            <li class="divider"></li>
                            <li><a href="${basepath}/account/orders"><span class="glyphicon glyphicon-th"></span>&nbsp;我的订单</a></li>
                        <#-- <li><a href="${basepath}/account/balance"><span class="glyphicon glyphicon-usd"></span>&nbsp;我的余额</a></li>&ndash;&gt;
                            <li><a href="${basepath}/account/lifecoin"><span class="glyphicon glyphicon-credit-card"></span>&nbsp;我的燊活币</a></li>
                            <li class="divider"></li>
                            <li><a href="${basepath}/account/discount"><span class="glyphicon glyphicon-tags"></span>&nbsp;我的优惠券</a></li>
                            <li><a href="${basepath}/account/score"><span class="glyphicon glyphicon-asterisk"></span>&nbsp;我的积分</a></li>
                            <li><a href="${basepath}/account/address"><span class="glyphicon glyphicon-send"></span>&nbsp;配送地址</a></li>
                            <li><a href="${basepath}/account/favorite"><span class="glyphicon glyphicon-heart"></span>&nbsp;收藏夹</a></li>
                            <li class="divider"></li>
                            <li><a href="${basepath}/account/exit"><span class="glyphicon glyphicon-pause"></span>&nbsp;退出系统</a></li>
                        </ul>
                      </span>
                    </span>
                    <span style="display: none;">
                      ${currentAccount().nickname!""}
                          (${currentAccount().loginType!""})
                    </span>
          <#else >
                        <a href="${basepath}/account/login">登陆</a>|<a href="${basepath}/account/register">注册</a>
          </#if>
           <a href="${basepath}/account/login">登陆</a>|<a href="${basepath}/account/register">注册</a>-->

                <a href="${basepath}/account/login">登陆</a>|<a href="${basepath}/account/register">注册</a>
                <a><img src="resource/images/guan_06.png"></a></div>
        </div>
        <div class="bottom_nav_wrap">

            <ul class="clearfix">
                <li><a href="${basepath}/index">首页</a></li>
               <#list systemManager().catalogs as item>
                    <li> <a href="${basepath}/catalog/${item.code}.html">${item.name}</a></li>
                </#list>
                <#if indexPage.topWord1?? && indexPage.topWord1Link??> <li>
                    <a href="${indexPage.topWord1Link!""}" target="_blank">${indexPage.topWord1!""}</a></li>
                </#if>
                <#if indexPage.topWord2?? && indexPage.topWord2Link??> <li>
                    <a href="${indexPage.topWord2Link!""}" target="_blank">${indexPage.topWord2!""}</a></li>
                </#if>
            </ul>
        </div>
    </div>
    <div class="lf collection"><a href="#"><img src="resource/images/guan_08.png"></a></div>
</div>
<div class="banner_wrap">
    <div class="banner_img">
    <#if indexPage.banner1Pic?? && indexPage.banner1Link??> <li>
        <a href="${indexPage.banner1Link!""} target="_blank"><img src="${systemSetting().imageRootPath}/${indexPage.banner1Pic!""}"></a>
    </#if>
        </div>
    <div class="second_nav_wrap">
        <div class="second_nav_conent">
            <div class="sort_total clearfix">
                <p class="lf">全部商品分类</p>
                <span class="rf com_icon"></span>
            </div>


      <#--
        <#list systemManager().catalogs as item>
            <div class="sidelist">
			<span>
				<h3>
                    <a href="${basepath}/catalog/${item.code}.html">${item.name}</a>
                </h3>
			</span>
                <div class="i-list">
                    <ul>
                        <#if item.children??>
                            <#list item.children as sItem>
                                <li>
                                    <a href="${basepath}/catalog/${sItem.code}.html">${sItem.name}</a>
                                </li>
                            </#list>
                        </#if>
                    </ul>
                    <div style="clear: both;"></div>

                    <#if item.superMenuProducts??>
                        <div style="border-top: 1px solid #f40;clear: both;" class="hotText">
                            <div style="font-weight: bold;padding-top: 5px;padding-bottom: 5px;">推荐热卖：</div>
                            <#list item.superMenuProducts as pItem>
                                <div style="margin-top: 5px;">
                                    &gt;<a title="${pItem.name}" target="_blank" href="${basepath}/product/${pItem.id}.html">
                                ${pItem.name}
                                </a>
                                </div>
                            </#list>
                        </div>
                    </#if>
                </div>
            </div>
        </#list>
-->

            <ul>
            <#list systemManager().catalogs as item>
                <li class="clearfix">
                    <a href="${basepath}/catalog/${item.code}.html">
                        <span class="lf com_icon nav_tip_icon tip_1"></span>
                        <p class="lf">     <a href="${basepath}/catalog/${item.code}.html">${item.name}</a></p>
                        <span class="com_icon rf arrow_bai"></span>
                    </a>
                </li>
            </#list>
            </ul>
        </div>
        <div class="nav_product_wrap">
            <div class="add_width clearfix">
                <div class="lf product_content">
                    <dl class="clearfix">
                        <dt class="lf">
                        <p>超值<span>大牌</span></p>
                        <p class="small_pro_tit">双倍积分</p>
                        </dt>
                        <dd class="rf">
                            <#if indexPage.smallBanner1Pic?? && indexPage.smallBanner1Link??> <li>
                                <a href="${indexPage.smallBanner1Link!""}target="_blank" ><img src="${systemSetting().imageRootPath}/${indexPage.smallBanner1Pic!""}"></a>
                            </#if>
                        </dd>
                    </dl>
                </div>
                <div class="lf product_content">
                    <dl class="clearfix">
                        <dt class="lf beautiful_wei">
                        <p>热销<span>美味</span></p>
                        <p class="small_pro_tit">买三赠一</p>
                        </dt>
                        <dd class="rf">
                        <#if indexPage.smallBanner2Pic?? && indexPage.smallBanner2Link??> <li>
                            <a href="${indexPage.smallBanner2Link!""}" target=" _Blank" ><img src="${systemSetting().imageRootPath}/${indexPage.smallBanner2Pic!""}"></a>
                        </#if>
                        </dd>
                    </dl>
                </div>
                <div class="lf product_content">
                    <dl class="clearfix">
                        <dt class="lf good_foot">
                        <p>进口<span>美食</span></p>
                        <p class="small_pro_tit">异域风情</p>
                        </dt>
                        <dd class="rf">
                        <#if indexPage.smallBanner3Pic?? && indexPage.smallBanner3Link??> <li>
                            <a href="${indexPage.smallBanner3Link!""}" target=" _Blank" ><img src="${systemSetting().imageRootPath}/${indexPage.smallBanner3Pic!""}"></a>
                        </#if>
                        </dd>
                    </dl>
                </div>
                <div class="lf product_content">
                    <dl class="clearfix">
                        <dt class="lf shar_vip">
                        <p>会员<span>专享</span></p>
                        <p class="small_pro_tit">20元红包</p>
                        </dt>
                        <dd class="rf">
                        <#if indexPage.smallBanner4Pic?? && indexPage.smallBanner4Link??> <li>
                            <a href="${indexPage.smallBanner4Link!""} target="_blank" ><img src="${systemSetting().imageRootPath}/${indexPage.smallBanner4Pic!""}"></a>
                        </#if>
                        </dd>
                    </dl>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="big_advangster">

<#if indexPage.middleBanner1Pic?? && indexPage.middleBanner1Link??>
    <a href="${indexPage.middleBanner1Link!""}  target="_blank"><img src="${systemSetting().imageRootPath}/${indexPage.middleBanner1Pic!""}"></a>
</#if>
<#if indexPage.middleBanner2Pic?? && indexPage.middleBanner2Link??>
    <a href="${indexPage.middleBanner2Link!""}  target="_blank"><img src="${systemSetting().imageRootPath}/${indexPage.middleBanner2Pic!""}"></a>
</#if>
</div>
<div class="today_pro_wrap">
    <h3>今日推荐<span>sell</span></h3>
    <div class="clearfix product_wrap">
        <a class="lf lf_prodct" href="${indexPage.commodityAreaLink1!""} target="_blank">
        <#if indexPage.commodityAreaPic1?? && indexPage.commodityAreaLink1??>
            <img src="${systemSetting().imageRootPath}/${indexPage.commodityAreaPic1!""}">
        </#if>
         <#--   <dl class="advange_txt">
                <dt><img src="resource/images/smlogo.png"></dt>
                <dd>
                    <p>爱夫威化饼干</p>
                    <p class="second_txt">德国进口</p>
                </dd>
            </dl>
            <div class="pro_price_wrap">
                尝鲜价<label>￥</lablel><span>39.90</span>
            </div>-->
        </a>
        <div class="rf rf_product">
            <ul class="clearfix">
            <#list productList1 as item>
                <li>
                    <div class="pro_pircture"><a href="${basepath}/product/${item.id}.html" target="_blank"><img style="width: 214px;height: 164px;" src="${systemSetting().imageRootPath}/${item.picture}"></a></div>
                    <p class="detail_pros">${item.name}</p>
                    <p class="price_big"><span>￥</span>${item.nowPrice}</p>
                    <span class="car_buy com_icon"></span>
                </li>
            </#list>
            </ul>
        </div>
    </div>
</div>
<div class="big_advangeter">
    <#if indexPage.hengBannerPic1?? && indexPage.hengBannerLink1??>
        <a href="${indexPage.hengBannerLink1!""} target="_blank" ><img src="${systemSetting().imageRootPath}/${indexPage.hengBannerPic1!""}"></a>
    </#if>
</div>
<div class="today_pro_wrap">
    <h3>新品尝鲜<span>new</span></h3>
    <div class="clearfix product_wrap">
        <a class="lf lf_prodct" href="${indexPage.commodityAreaLink2!""} target="_blank">
        <#if indexPage.commodityAreaPic2?? && indexPage.commodityAreaLink2??>
        <#-- <a href="${indexPage.commodityAreaLink2!""} target="_blank" >--><img src="${systemSetting().imageRootPath}/${indexPage.commodityAreaPic2!""}"><#--</a>-->
        </#if>
    <#--  <dl class="advange_txt">
      <dt><img src="resource/images/smlogo.png">
      </dt>
<dd>
          <p>爱夫威化饼干</p>
          <p class="second_txt">德国进口</p>
      </dd>
            </dl>
           <div class="pro_price_wrap">
                尝鲜价<label>￥</lablel><span>39.90</span>
            </div>-->
        </a>
        <div class="rf rf_product">
            <ul class="clearfix">
            <#list productList2 as item>
                <li>
                    <div class="pro_pircture"><a href="${basepath}/product/${item.id}.html" target="_blank"><img style="width: 214px;height: 164px;" src="${systemSetting().imageRootPath}/${item.picture}"></a></div>
                    <p class="detail_pros">${item.name}</p>
                    <p class="price_big"><span>￥</span>${item.nowPrice}</p>
                    <span class="car_buy com_icon"></span>
                </li>
            </#list>
            </ul>
        </div>
    </div>
</div>
<div class="big_advangeter"><#--<a href="#"><img src="resource/images/guan_46.png"></a>-->
<#if indexPage.hengBannerPic2?? && indexPage.hengBannerLink2??>
    <a href="${indexPage.hengBannerLink2!""} target="_blank" ><img src="${systemSetting().imageRootPath}/${indexPage.hengBannerPic2!""}"></a>
</#if>
</div>
<div class="today_pro_wrap">
    <h3 class="border_b_1">
        饼干糕点<span>cookies</span>
     <#--   <div class="pro_tit_nav">
            <a href="#">小老板</a> / <a href="#">小老板</a> / <a href="#">小老板</a> / <a href="#">小老板</a> / <a href="#">小老板</a> / <a href="#">小老板</a>
        </div>-->
    </h3>
    <div class="clearfix product_wrap add_bor_1">
        <div class="lf lf_big_prodct">
            <div class="big_product_img">
             <#--   <img src="resource/images/guan_50.jpg">-->
             <#if indexPage.commodityAreaPic3?? && indexPage.commodityAreaLink3??>
                 <a href="${indexPage.commodityAreaLink3!""} target="_blank" ><img src="${systemSetting().imageRootPath}/${indexPage.commodityAreaPic3!""}"></a>
             </#if>
                <span class="hot_icon"></span>
            </div>
          <#--  <ul class="clearfix product_nav">
                <li><a href="#">威化</a></li>
                <li><a href="#">曲奇</a></li>
                <li><a href="#">点心</a></li>
            </ul>-->
        </div>
        <div class="rf rf_product big_pro_img">
            <ul class="clearfix">
            <#list productList3 as item>
                <li>
                    <div class="pro_pircture"><a href="${basepath}/product/${item.id}.html" target="_blank"><img style="width: 214px;height: 164px;" src="${systemSetting().imageRootPath}/${item.picture}"></a></div>
                    <p class="detail_pros">${item.name}</p>
                    <p class="price_big"><span>￥</span>${item.nowPrice}</p>
                    <span class="car_buy com_icon"></span>
                </li>
            </#list>
            </ul>
        </div>
    </div>
</div>
<div class="today_pro_wrap">
    <h3 class="border_b_1">
        果干坚果<span>cookies</span>
      <#--  <div class="pro_tit_nav">
            <a href="#">小老板</a> / <a href="#">小老板</a> / <a href="#">小老板</a> / <a href="#">小老板</a> / <a href="#">小老板</a> / <a href="#">小老板</a>
        </div>-->
    </h3>
    <div class="clearfix product_wrap add_bor_1">
        <div class="lf lf_big_prodct">
            <div class="big_product_img">
              <#--  <img src="resource/images/guan_50.jpg">-->
              <#if indexPage.commodityAreaPic4?? && indexPage.commodityAreaLink4??>
                  <a href="${indexPage.commodityAreaLink4!""} target="_blank" ><img src="${systemSetting().imageRootPath}/${indexPage.commodityAreaPic4!""}"></a>
              </#if>
                <span class="hot_icon"></span>
            </div>
           <#-- <ul class="clearfix product_nav">
                <li><a href="#">威化</a></li>
                <li><a href="#">曲奇</a></li>
                <li><a href="#">点心</a></li>
            </ul>-->
        </div>
        <div class="rf rf_product big_pro_img">
            <ul class="clearfix">
            <#list productList4 as item>
                <li>
                    <div class="pro_pircture"><a href="${basepath}/product/${item.id}.html" target="_blank"><img style="width: 214px;height: 164px;" src="${systemSetting().imageRootPath}/${item.picture}"></a></div>
                    <p class="detail_pros">${item.name}</p>
                    <p class="price_big"><span>￥</span>${item.nowPrice}</p>
                    <span class="car_buy com_icon"></span>
                </li>
            </#list>
            </ul>
        </div>
    </div>
</div>
<div class="slide_banner">
    <ul>
        <li><a href="#" class="com_icon slide_1"></a></li>
        <li><a href="#" class="com_icon slide_2"></a></li>
        <li><a href="#" class="com_icon slide_3"></a></li>
        <li><a href="#" class="com_icon slide_4"></a></li>
        <li><a href="#" class="com_icon slide_5"></a></li>
        <li><a href="#" class="com_icon slide_6"></a></li>
        <li><a href="#" class="com_icon slide_7"></a></li>
        <li><a href="#" class="com_icon slide_8"></a></li>
        <li><a href="#" class="com_icon slide_9"></a></li>
        <li><a href="#" class="com_icon slide_10"></a></li>
        <li><a href="#" class="com_icon slide_11"></a></li>
        <li class="bor_b_none">
            <p>返回顶部</p>
            <span class="com_icon"></span>
        </li>
    </ul>
</div>
<script>
    $("#searchBtn").click(function () {
        search()
    });
    //搜索商品
    function search(){
        var _key = $.trim($("#key").val());
        if(_key==''){
            return false;
        }
        $("#searchForm").submit();
    }
</script>
</body>
</@html.htmlBase>