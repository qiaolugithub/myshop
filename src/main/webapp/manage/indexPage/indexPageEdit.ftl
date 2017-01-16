<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="修改密码">
    <form name="form" action="${basepath}/manage/indexPage" method="post">
        <div style="text-align: center;border-bottom: 1px solid #ccc;padding: 5px;">
            <button method="update" class="btn btn-success">
                <i class="icon-ok icon-white"></i> 保存
            </button>
        </div>
		<table class="table table-bordered" >
			<tr>
				<td colspan="6" style="background-color: #dff0d8;text-align: center;">
					<strong>修改首页</strong>
				</td>
			</tr>
			<tr style="display:none;">
				<th>id</th>
				<td><input type="hidden" value="1" name="id"></td>
			</tr>
            <tr>
                <th style="text-align: right;">轮播图上文字1</th>
                <td style="text-align: left;">
                    <input type="text" id="topWord1"  name="topWord1" style="width: 80%;" value="${indexPage.topWord1!""}"  data-rule="length[1~200];" />
                </td>
                <th style="text-align: right;">轮播图上文字1-链接地址</th>
                <td style="text-align: left;"><input type="text" name="topWord1Link"  value="${indexPage.topWord1Link!""}"  data-rule="length[1~200];"
                                                     id="topWord1Link"  /></td>
            </tr>
            <tr>
                <th style="text-align: right;">轮播图上文字2</th>
                <td style="text-align: left;">
                    <input type="text" id="topWord2"  name="topWord2" style="width: 80%;" value="${indexPage.topWord2!""}"  data-rule="length[1~200];" />
                </td>
                <th style="text-align: right;">轮播图上文字2-链接地址</th>
                <td style="text-align: left;"><input type="text" name="topWord2Link" value="${indexPage.topWord2Link!""}"  data-rule="length[1~200];"
                                                     id="topWord2Link" /></td>
            </tr>
			<tr>

				<th style="text-align: right;">首页轮播图1
                    <h6><span style="color:red">至少一个轮播图最多三个</span></h6>
                </th>
				<td style="text-align: left;">
                    <table class="table table-bordered">
                        <tr id="firstTr">
                            <td>
                                <#list [0..10] as item>
                                    <div>
                                        <input type="button" name="filemanager" value="浏览图片" class="btn btn-warning"/>
                                        <input type="text" id="banner1Pic" ccc="imagesInput" name="banner1Pic" style="width: 80%;" value="${indexPage.banner1Pic!""}"  data-rule="length[1~200];" />
                                    </div>
                                </#list>
                            </td>
                        </tr>
                    </table>
                </td>
				<th style="text-align: right;">首页轮播图1-链接地址</th>
				<td style="text-align: left;"><input type="text" name="banner1Link" value="${indexPage.banner1Link!""}"  data-rule="length[1~500];"
						id="banner1Link" /></td>
			</tr>
          <#--  <tr>
                <th style="text-align: right;">首页轮播图2</th>
                <td style="text-align: left;">
                    <table class="table table-bordered">
                        <tr id="firstTr">
                            <td>
                                <#list [0..10] as item>
                                    <div>
                                        <input type="button" name="filemanager" value="浏览图片" class="btn btn-warning"/>
                                        <input type="text" id="banner2Pic" ccc="imagesInput" name="banner2Pic" style="width: 80%;" value="${indexPage.banner2Pic!""}"  data-rule="length[1~200];" />
                                    </div>
                                </#list>
                            </td>
                        </tr>
                    </table>
                </td>
                <th style="text-align: right;">首页轮播图2-链接地址</th>
                <td style="text-align: left;"><input type="text" name="banner2Link" value="${indexPage.banner2Link!""}"  data-rule="length[1~500];"
                                                     id="banner2Link" /></td>
            </tr>
            <tr>
                <th style="text-align: right;">首页轮播图3</th>
                <td style="text-align: left;"> <table class="table table-bordered">
                    <tr id="firstTr">
                        <td>
                            <#list [0..10] as item>
                                <div>
                                    <input type="button" name="filemanager" value="浏览图片" class="btn btn-warning"/>
                                    <input type="text" id="banner3Pic" ccc="imagesInput" name="banner3Pic" style="width: 80%;" value="${indexPage.banner3Pic!""}"  data-rule="length[1~200];" />
                                </div>
                            </#list>
                        </td>
                    </tr>
                </table></td>
                <th style="text-align: right;">首页轮播图3-链接地址</th>
                <td style="text-align: left;"><input type="text" name="banner3Link" value="${indexPage.banner3Link!""}"  data-rule="length[1~500];"
                                                     id="banner3Link" /></td>
            </tr>-->

            <tr>
                <th style="text-align: right;">轮播图下小图1
                </th>
                <td style="text-align: left;">
                    <table class="table table-bordered">
                        <tr id="firstTr">
                            <td>
                                <#list [0..10] as item>
                                    <div>
                                        <input type="button" name="filemanager" value="浏览图片" class="btn btn-warning"/>
                                        <input type="text" id="smallBanner1Pic" ccc="imagesInput" name="smallBanner1Pic" style="width: 80%;" value="${indexPage.smallBanner1Pic!""}"  data-rule="length[1~200];" />
                                    </div>
                                </#list>
                            </td>
                        </tr>
                    </table>
                </td>
                <th style="text-align: right;">轮播图下小图1-链接地址</th>
                <td style="text-align: left;"><input type="text" name="smallBanner1Link" value="${indexPage.smallBanner1Link!""}"  data-rule="length[1~500];"
                                                     id="smallBanner1Link" /></td>
            </tr>

            <tr>
                <th style="text-align: right;">轮播图下小图2
                </th>
                <td style="text-align: left;">
                    <table class="table table-bordered">
                        <tr id="firstTr">
                            <td>
                                <#list [0..10] as item>
                                    <div>
                                        <input type="button" name="filemanager" value="浏览图片" class="btn btn-warning"/>
                                        <input type="text" id="smallBanner2Pic" ccc="imagesInput" name="smallBanner2Pic" style="width: 80%;" value="${indexPage.smallBanner2Pic!""}"  data-rule="length[1~200];" />
                                    </div>
                                </#list>
                            </td>
                        </tr>
                    </table>
                </td>
                <th style="text-align: right;">轮播图下小图2-链接地址</th>
                <td style="text-align: left;"><input type="text" name="smallBanner2Link" value="${indexPage.smallBanner2Link!""}"  data-rule="length[1~500];"
                                                     id="smallBanner2Link" /></td>
            </tr>
            <tr>
                <th style="text-align: right;">轮播图下小图3
                </th>
                <td style="text-align: left;">
                    <table class="table table-bordered">
                        <tr id="firstTr">
                            <td>
                                <#list [0..10] as item>
                                    <div>
                                        <input type="button" name="filemanager" value="浏览图片" class="btn btn-warning"/>
                                        <input type="text" id="smallBanner3Pic" ccc="imagesInput" name="smallBanner3Pic" style="width: 80%;" value="${indexPage.smallBanner3Pic!""}"  data-rule="length[1~200];" />
                                    </div>
                                </#list>
                            </td>
                        </tr>
                    </table>
                </td>
                <th style="text-align: right;">轮播图下小图3-链接地址</th>
                <td style="text-align: left;"><input type="text" name="smallBanner3Link" value="${indexPage.smallBanner3Link!""}"  data-rule="length[1~500];"
                                                     id="smallBanner3Link" /></td>
            </tr>
            <tr>
                <th style="text-align: right;">轮播图下小图4
                </th>
                <td style="text-align: left;">
                    <table class="table table-bordered">
                        <tr id="firstTr">
                            <td>
                                <#list [0..10] as item>
                                    <div>
                                        <input type="button" name="filemanager" value="浏览图片" class="btn btn-warning"/>
                                        <input type="text" id="smallBanner4Pic" ccc="imagesInput" name="smallBanner4Pic" style="width: 80%;" value="${indexPage.smallBanner4Pic!""}"  data-rule="length[1~200];" />
                                    </div>
                                </#list>
                            </td>
                        </tr>
                    </table>
                </td>
                <th style="text-align: right;">轮播图下小图4-链接地址</th>
                <td style="text-align: left;"><input type="text" name="smallBanner4Link" value="${indexPage.smallBanner4Link!""}"  data-rule="length[1~500];"
                                                     id="smallBanner4Link" /></td>
            </tr>


            <tr>
                <th style="text-align: right;">小图下中等大小banner图1
                </th>
                <td style="text-align: left;">
                    <table class="table table-bordered">
                        <tr id="firstTr">
                            <td>
                                <#list [0..10] as item>
                                    <div>
                                        <input type="button" name="filemanager" value="浏览图片" class="btn btn-warning"/>
                                        <input type="text" id="middleBanner1Pic" ccc="imagesInput" name="middleBanner1Pic" style="width: 80%;" value="${indexPage.middleBanner1Pic!""}"  data-rule="length[1~200];" />
                                    </div>
                                </#list>
                            </td>
                        </tr>
                    </table>
                </td>
                <th style="text-align: right;">小图下中等大小banner图1-链接地址</th>
                <td style="text-align: left;"><input type="text" name="middleBanner1Link" value="${indexPage.middleBanner1Link!""}"  data-rule="length[1~500];"
                                                     id="middleBanner1Link" /></td>
            </tr>
            <tr>
                <th style="text-align: right;">小图下中等大小banner图2
                </th>
                <td style="text-align: left;">
                    <table class="table table-bordered">
                        <tr id="firstTr">
                            <td>
                                <#list [0..10] as item>
                                    <div>
                                        <input type="button" name="filemanager" value="浏览图片" class="btn btn-warning"/>
                                        <input type="text" id="middleBanner2Pic" ccc="imagesInput" name="middleBanner2Pic" style="width: 80%;" value="${indexPage.middleBanner2Pic!""}"  data-rule="length[1~200];" />
                                    </div>
                                </#list>
                            </td>
                        </tr>
                    </table>
                </td>
                <th style="text-align: right;">小图下中等大小banner图2-链接地址</th>
                <td style="text-align: left;"><input type="text" name="middleBanner2Link" value="${indexPage.middleBanner2Link!""}"  data-rule="length[1~500];"
                                                     id="middleBanner2Link" /></td>
            </tr>

            <#--商品1区域-->
            <tr>
                <th style="text-align: right;">商品1区左侧图
                </th>
                <td style="text-align: left;">
                    <table class="table table-bordered">
                        <tr id="firstTr">
                            <td>
                                <#list [0..10] as item>
                                    <div>
                                        <input type="button" name="filemanager" value="浏览图片" class="btn btn-warning"/>
                                        <input type="text" id="commodityAreaPic1" ccc="imagesInput" name="commodityAreaPic1" style="width: 80%;" value="${indexPage.commodityAreaPic1!""}"  data-rule="length[1~200];" />
                                    </div>
                                </#list>
                            </td>
                        </tr>
                    </table>
                </td>
                <th style="text-align: right;">商品1区左侧图-链接地址</th>
                <td style="text-align: left;"><input type="text" name="commodityAreaLink1" value="${indexPage.commodityAreaLink1!""}"  data-rule="length[1~500];"
                                                     id="commodityAreaLink1" /></td>
                <th style="text-align: right;">商品1区-<h6><span style="color:red;">商品id英文逗号分隔限8个</span></h6></th>
                <td style="text-align: left;"><input type="text" name="commodityAreaStr1" value="${indexPage.commodityAreaStr1!""}"  data-rule="length[1~500];"
                                                     id="commodityAreaStr1" /></td>
            </tr>

            <#--商品一区下图片-->
            <tr>
                <th style="text-align: right;">商品1区下图片
                </th>
                <td style="text-align: left;">
                    <table class="table table-bordered">
                        <tr id="firstTr">
                            <td>
                                <#list [0..10] as item>
                                    <div>
                                        <input type="button" name="filemanager" value="浏览图片" class="btn btn-warning"/>
                                        <input type="text" id="hengBannerPic1" ccc="imagesInput" name="hengBannerPic1" style="width: 80%;" value="${indexPage.hengBannerPic1!""}"  data-rule="length[1~200];" />
                                    </div>
                                </#list>
                            </td>
                        </tr>
                    </table>
                </td>
                <th style="text-align: right;">商品1区下图片-链接地址</th>
                <td style="text-align: left;"><input type="text" name="hengBannerLink1" value="${indexPage.hengBannerLink1!""}"  data-rule="length[1~500];"
                                                     id="hengBannerLink1" /></td>
            </tr>

        <#--商品2区域-->
            <tr>
                <th style="text-align: right;">商品2区左侧图
                </th>
                <td style="text-align: left;">
                    <table class="table table-bordered">
                        <tr id="firstTr">
                            <td>
                                <#list [0..10] as item>
                                    <div>
                                        <input type="button" name="filemanager" value="浏览图片" class="btn btn-warning"/>
                                        <input type="text" id="commodityAreaPic2" ccc="imagesInput" name="commodityAreaPic2" style="width: 80%;" value="${indexPage.commodityAreaPic2!""}"  data-rule="length[1~200];" />
                                    </div>
                                </#list>
                            </td>
                        </tr>
                    </table>
                </td>
                <th style="text-align: right;">商品2区左侧图-链接地址</th>
                <td style="text-align: left;"><input type="text" name="commodityAreaLink2" value="${indexPage.commodityAreaLink2!""}"  data-rule="length[1~500];"
                                                     id="commodityAreaLink2" /></td>
                <th style="text-align: right;">商品2区-<h6><span style="color:red;">商品id英文逗号分隔限8个</span></h6></th>
                <td style="text-align: left;"><input type="text" name="commodityAreaStr2" value="${indexPage.commodityAreaStr2!""}"  data-rule="length[1~500];"
                                                     id="commodityAreaStr2" /></td>
            </tr>
        <#--商品2区下图片-->
            <tr>
                <th style="text-align: right;">商品2区下图片
                </th>
                <td style="text-align: left;">
                    <table class="table table-bordered">
                        <tr id="firstTr">
                            <td>
                                <#list [0..10] as item>
                                    <div>
                                        <input type="button" name="filemanager" value="浏览图片" class="btn btn-warning"/>
                                        <input type="text" id="hengBannerPic2" ccc="imagesInput" name="hengBannerPic2" style="width: 80%;" value="${indexPage.hengBannerPic2!""}"  data-rule="length[1~200];" />
                                    </div>
                                </#list>
                            </td>
                        </tr>
                    </table>
                </td>
                <th style="text-align: right;">商品2区下图片-链接地址</th>
                <td style="text-align: left;"><input type="text" name="hengBannerLink2" value="${indexPage.hengBannerLink2!""}"  data-rule="length[1~500];"
                                                     id="hengBannerLink2" /></td>
            </tr>
        <#--商品3区域-->
            <tr>
                <th style="text-align: right;">商品3区左侧图
                </th>
                <td style="text-align: left;">
                    <table class="table table-bordered">
                        <tr id="firstTr">
                            <td>
                                <#list [0..10] as item>
                                    <div>
                                        <input type="button" name="filemanager" value="浏览图片" class="btn btn-warning"/>
                                        <input type="text" id="commodityAreaPic3" ccc="imagesInput" name="commodityAreaPic3" style="width: 80%;" value="${indexPage.commodityAreaPic3!""}"  data-rule="length[1~200];" />
                                    </div>
                                </#list>
                            </td>
                        </tr>
                    </table>
                </td>
                <th style="text-align: right;">商品3区左侧图-链接地址</th>
                <td style="text-align: left;"><input type="text" name="commodityAreaLink3" value="${indexPage.commodityAreaLink3!""}"  data-rule="length[1~500];"
                                                     id="commodityAreaLink3" /></td>
                <th style="text-align: right;">商品3区-<h6><span style="color:red;">商品id英文逗号分隔限6个</span></h6></th>
                <td style="text-align: left;"><input type="text" name="commodityAreaStr3" value="${indexPage.commodityAreaStr3!""}"  data-rule="length[1~500];"
                                                     id="commodityAreaStr3" /></td>
            </tr>

        <#--商品4区域-->
            <tr>
                <th style="text-align: right;">商品4区左侧图
                </th>
                <td style="text-align: left;">
                    <table class="table table-bordered">
                        <tr id="firstTr">
                            <td>
                                <#list [0..10] as item>
                                    <div>
                                        <input type="button" name="filemanager" value="浏览图片" class="btn btn-warning"/>
                                        <input type="text" id="commodityAreaPic4" ccc="imagesInput" name="commodityAreaPic4" style="width: 80%;" value="${indexPage.commodityAreaPic4!""}"  data-rule="length[1~200];" />
                                    </div>
                                </#list>
                            </td>
                        </tr>
                    </table>
                </td>
                <th style="text-align: right;">商品4区左侧图-链接地址</th>
                <td style="text-align: left;"><input type="text" name="commodityAreaLink4" value="${indexPage.commodityAreaLink4!""}"  data-rule="length[1~500];"
                                                     id="commodityAreaLink4" /></td>
                <th style="text-align: right;">商品1区-<h6><span style="color:red;">商品id英文逗号分隔限6个</span></h6></th>
                <td style="text-align: left;"><input type="text" name="commodityAreaStr4" value="${indexPage.commodityAreaStr4!""}"  data-rule="length[1~500];"
                                                     id="commodityAreaStr4" /></td>
            </tr>
		</table>
        </form>

<script>
    KindEditor.ready(function(K) {
        var editor = K.editor({
            fileManagerJson : '${basepath}/editor/fileManager'
        });
        K('input[name=filemanager]').click(function() {
            var imagesInputObj = $(this).parent().children("input[ccc=imagesInput]");
            editor.loadPlugin('filemanager', function() {
                editor.plugin.filemanagerDialog({
                    viewType : 'VIEW',
                    dirName : 'image',
                    clickFn : function(url, title) {
                        //K('#picture').val(url);
                        //alert(url);
                        imagesInputObj.val(url);
                        editor.hideDialog();
                        clearRootImagePath(imagesInputObj);//$("#picture"));
                    }
                });
            });
        });

    });
</script>
</@page.pageBase>