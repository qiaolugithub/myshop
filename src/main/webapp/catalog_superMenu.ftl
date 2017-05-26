<#--左侧导航栏、热卖商品、文章、事项-->
<link rel="stylesheet"
	href="${basepath}/resource/js/superMenu/css/css.css"
	type="text/css">

<div id="sidebar">
	<#list systemManager().catalogs as item>
       <div class="sidelist">
			<span>
				<h3>
					<a href="${basepath}/catalog/${item.code}.html">
                        <#if item.name == "饼干威化">
                            <img src="${basepath}/resource/images/ico_03.png" class="firco_ico1">
                        </#if>

                        <#if item.name == "饮品冲调">
                            <img src="${basepath}/resource/images/nea_03.png" class="firco_ico2">
                        </#if>

                        <#if item.name == "泡面速食">
                            <img src="${basepath}/resource/images/nea_07.png" class="firco_ico3">
                        </#if>

                        <#if item.name == "糖果糕点">
                            <img src="${basepath}/resource/images/nea_11.png" class="firco_ico4">
                        </#if>

                        <#if item.name == "休闲零食">
                            <img src="${basepath}/resource/images/nea_14.png" class="firco_ico5">
                        </#if>

                        <#if item.name == "元气早餐">
                            <img src="${basepath}/resource/images/nea_18.png" class="firco_ico6">
                        </#if>

                        <#if item.name == "油粮调味">
                            <img src="${basepath}/resource/images/nea_22.png" class="firco_ico7">
                        </#if>

                    ${item.name}</a>
				</h3>
			</span>
			<div class="i-list">
				<ul>
					<#if item.children??>
						<#list item.children as sItem>
						<li>
		          			<a href="${basepath}/catalog/${sItem.code}.html">
                            ${sItem.name}</a>
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
</div>