package net.jeeshop.services.common;

import net.jeeshop.core.dao.page.PagerModel;

import java.io.Serializable;

public class IndexPage  extends PagerModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    /** banner1图 */
    private String banner1Pic;

    /** banner1链接 */
    private String banner1Link;

    /** banner2图 */
    private String banner2Pic;

    /** t_indexpage.banner2_link */
    private String banner2Link;

    /** t_indexpage.banner3_pic */
    private String banner3Pic;

    /** t_indexpage.banner3_link */
    private String banner3Link;

    /** 顶部文字 */
    private String topWord1;

    /** 顶部文字链接 */
    private String topWord1Link;

    /** t_indexpage.top_word2 */
    private String topWord2;

    /** t_indexpage.top_word2_link */
    private String topWord2Link;

    /** 小的四个banner图 */
    private String smallBanner1Pic;

    /** 小的四个banner链接 */
    private String smallBanner1Link;

    /** t_indexpage.small_banner2_pic */
    private String smallBanner2Pic;

    /** t_indexpage.small_banner2_link */
    private String smallBanner2Link;

    /** t_indexpage.small_banner3_pic */
    private String smallBanner3Pic;

    /** t_indexpage.small_banner3_link */
    private String smallBanner3Link;

    /** t_indexpage.small_banner4_pic */
    private String smallBanner4Pic;

    /** t_indexpage.small_banner4_link */
    private String smallBanner4Link;

    /** 中间的中等大小图片 */
    private String middleBanner1Pic;

    /** 中间的中等大小图片链接 */
    private String middleBanner1Link;

    /** t_indexpage.middle_banner2_pic */
    private String middleBanner2Pic;

    /** t_indexpage.middle_banner2_link */
    private String middleBanner2Link;

    /** 商品区1的图 */
    private String commodityAreaPic1;

    /** 商品区1的链接 */
    private String commodityAreaLink1;

    /** 逗号分隔的商品id */
    private String commodityAreaStr1;

    /** t_indexpage.commodity_area_pic2 */
    private String commodityAreaPic2;

    /** t_indexpage.commodity_area_link2 */
    private String commodityAreaLink2;

    /** 逗号分隔的商品id */
    private String commodityAreaStr2;

    /** t_indexpage.commodity_area_pic3 */
    private String commodityAreaPic3;

    /** t_indexpage.commodity_area_link3 */
    private String commodityAreaLink3;

    /** 逗号分隔的商品id */
    private String commodityAreaStr3;

    /** t_indexpage.commodity_area_pic4 */
    private String commodityAreaPic4;

    /** t_indexpage.commodity_area_link4 */
    private String commodityAreaLink4;

    /** 逗号分隔的商品id */
    private String commodityAreaStr4;

    /** 商品区3的右上角链接名 */
    private String commodityButton3Name1;

    /** 商品区3的右上角链接 */
    private String commodityButton3Link1;

    /** t_indexpage.commodity_button3_name_2 */
    private String commodityButton3Name2;

    /** t_indexpage.commodity_button3_link_2 */
    private String commodityButton3Link2;

    /** t_indexpage.commodity_button3_name_3 */
    private String commodityButton3Name3;

    /** t_indexpage.commodity_button3_link_3 */
    private String commodityButton3Link3;

    /** 横图片 */
    private String hengBannerPic1;

    /** 横图片链接 */
    private String hengBannerLink1;

    /** t_indexpage.heng_banner_pic2 */
    private String hengBannerPic2;

    /** t_indexpage.heng_banner_link2 */
    private String hengBannerLink2;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getBanner1Pic() {
        return banner1Pic;
    }

    public void setBanner1Pic(String banner1Pic) {
        this.banner1Pic = banner1Pic == null ? null : banner1Pic.trim();
    }

    public String getBanner1Link() {
        return banner1Link;
    }

    public void setBanner1Link(String banner1Link) {
        this.banner1Link = banner1Link == null ? null : banner1Link.trim();
    }

    public String getBanner2Pic() {
        return banner2Pic;
    }

    public void setBanner2Pic(String banner2Pic) {
        this.banner2Pic = banner2Pic == null ? null : banner2Pic.trim();
    }

    public String getBanner2Link() {
        return banner2Link;
    }

    public void setBanner2Link(String banner2Link) {
        this.banner2Link = banner2Link == null ? null : banner2Link.trim();
    }

    public String getBanner3Pic() {
        return banner3Pic;
    }

    public void setBanner3Pic(String banner3Pic) {
        this.banner3Pic = banner3Pic == null ? null : banner3Pic.trim();
    }

    public String getBanner3Link() {
        return banner3Link;
    }

    public void setBanner3Link(String banner3Link) {
        this.banner3Link = banner3Link == null ? null : banner3Link.trim();
    }

    public String getTopWord1() {
        return topWord1;
    }

    public void setTopWord1(String topWord1) {
        this.topWord1 = topWord1 == null ? null : topWord1.trim();
    }

    public String getTopWord1Link() {
        return topWord1Link;
    }

    public void setTopWord1Link(String topWord1Link) {
        this.topWord1Link = topWord1Link == null ? null : topWord1Link.trim();
    }

    public String getTopWord2() {
        return topWord2;
    }

    public void setTopWord2(String topWord2) {
        this.topWord2 = topWord2 == null ? null : topWord2.trim();
    }

    public String getTopWord2Link() {
        return topWord2Link;
    }

    public void setTopWord2Link(String topWord2Link) {
        this.topWord2Link = topWord2Link == null ? null : topWord2Link.trim();
    }

    public String getSmallBanner1Pic() {
        return smallBanner1Pic;
    }

    public void setSmallBanner1Pic(String smallBanner1Pic) {
        this.smallBanner1Pic = smallBanner1Pic == null ? null : smallBanner1Pic.trim();
    }

    public String getSmallBanner1Link() {
        return smallBanner1Link;
    }

    public void setSmallBanner1Link(String smallBanner1Link) {
        this.smallBanner1Link = smallBanner1Link == null ? null : smallBanner1Link.trim();
    }

    public String getSmallBanner2Pic() {
        return smallBanner2Pic;
    }

    public void setSmallBanner2Pic(String smallBanner2Pic) {
        this.smallBanner2Pic = smallBanner2Pic == null ? null : smallBanner2Pic.trim();
    }

    public String getSmallBanner2Link() {
        return smallBanner2Link;
    }

    public void setSmallBanner2Link(String smallBanner2Link) {
        this.smallBanner2Link = smallBanner2Link == null ? null : smallBanner2Link.trim();
    }

    public String getSmallBanner3Pic() {
        return smallBanner3Pic;
    }

    public void setSmallBanner3Pic(String smallBanner3Pic) {
        this.smallBanner3Pic = smallBanner3Pic == null ? null : smallBanner3Pic.trim();
    }

    public String getSmallBanner3Link() {
        return smallBanner3Link;
    }

    public void setSmallBanner3Link(String smallBanner3Link) {
        this.smallBanner3Link = smallBanner3Link == null ? null : smallBanner3Link.trim();
    }

    public String getSmallBanner4Pic() {
        return smallBanner4Pic;
    }

    public void setSmallBanner4Pic(String smallBanner4Pic) {
        this.smallBanner4Pic = smallBanner4Pic == null ? null : smallBanner4Pic.trim();
    }

    public String getSmallBanner4Link() {
        return smallBanner4Link;
    }

    public void setSmallBanner4Link(String smallBanner4Link) {
        this.smallBanner4Link = smallBanner4Link == null ? null : smallBanner4Link.trim();
    }

    public String getMiddleBanner1Pic() {
        return middleBanner1Pic;
    }

    public void setMiddleBanner1Pic(String middleBanner1Pic) {
        this.middleBanner1Pic = middleBanner1Pic == null ? null : middleBanner1Pic.trim();
    }

    public String getMiddleBanner1Link() {
        return middleBanner1Link;
    }

    public void setMiddleBanner1Link(String middleBanner1Link) {
        this.middleBanner1Link = middleBanner1Link == null ? null : middleBanner1Link.trim();
    }

    public String getMiddleBanner2Pic() {
        return middleBanner2Pic;
    }

    public void setMiddleBanner2Pic(String middleBanner2Pic) {
        this.middleBanner2Pic = middleBanner2Pic == null ? null : middleBanner2Pic.trim();
    }

    public String getMiddleBanner2Link() {
        return middleBanner2Link;
    }

    public void setMiddleBanner2Link(String middleBanner2Link) {
        this.middleBanner2Link = middleBanner2Link == null ? null : middleBanner2Link.trim();
    }

    public String getCommodityAreaPic1() {
        return commodityAreaPic1;
    }

    public void setCommodityAreaPic1(String commodityAreaPic1) {
        this.commodityAreaPic1 = commodityAreaPic1 == null ? null : commodityAreaPic1.trim();
    }

    public String getCommodityAreaLink1() {
        return commodityAreaLink1;
    }

    public void setCommodityAreaLink1(String commodityAreaLink1) {
        this.commodityAreaLink1 = commodityAreaLink1 == null ? null : commodityAreaLink1.trim();
    }

    public String getCommodityAreaStr1() {
        return commodityAreaStr1;
    }

    public void setCommodityAreaStr1(String commodityAreaStr1) {
        this.commodityAreaStr1 = commodityAreaStr1 == null ? null : commodityAreaStr1.trim();
    }

    public String getCommodityAreaPic2() {
        return commodityAreaPic2;
    }

    public void setCommodityAreaPic2(String commodityAreaPic2) {
        this.commodityAreaPic2 = commodityAreaPic2 == null ? null : commodityAreaPic2.trim();
    }

    public String getCommodityAreaLink2() {
        return commodityAreaLink2;
    }

    public void setCommodityAreaLink2(String commodityAreaLink2) {
        this.commodityAreaLink2 = commodityAreaLink2 == null ? null : commodityAreaLink2.trim();
    }

    public String getCommodityAreaStr2() {
        return commodityAreaStr2;
    }

    public void setCommodityAreaStr2(String commodityAreaStr2) {
        this.commodityAreaStr2 = commodityAreaStr2 == null ? null : commodityAreaStr2.trim();
    }

    public String getCommodityAreaPic3() {
        return commodityAreaPic3;
    }

    public void setCommodityAreaPic3(String commodityAreaPic3) {
        this.commodityAreaPic3 = commodityAreaPic3 == null ? null : commodityAreaPic3.trim();
    }

    public String getCommodityAreaLink3() {
        return commodityAreaLink3;
    }

    public void setCommodityAreaLink3(String commodityAreaLink3) {
        this.commodityAreaLink3 = commodityAreaLink3 == null ? null : commodityAreaLink3.trim();
    }

    public String getCommodityAreaStr3() {
        return commodityAreaStr3;
    }

    public void setCommodityAreaStr3(String commodityAreaStr3) {
        this.commodityAreaStr3 = commodityAreaStr3 == null ? null : commodityAreaStr3.trim();
    }

    public String getCommodityAreaPic4() {
        return commodityAreaPic4;
    }

    public void setCommodityAreaPic4(String commodityAreaPic4) {
        this.commodityAreaPic4 = commodityAreaPic4 == null ? null : commodityAreaPic4.trim();
    }

    public String getCommodityAreaLink4() {
        return commodityAreaLink4;
    }

    public void setCommodityAreaLink4(String commodityAreaLink4) {
        this.commodityAreaLink4 = commodityAreaLink4 == null ? null : commodityAreaLink4.trim();
    }

    public String getCommodityAreaStr4() {
        return commodityAreaStr4;
    }

    public void setCommodityAreaStr4(String commodityAreaStr4) {
        this.commodityAreaStr4 = commodityAreaStr4 == null ? null : commodityAreaStr4.trim();
    }

    public String getCommodityButton3Name1() {
        return commodityButton3Name1;
    }

    public void setCommodityButton3Name1(String commodityButton3Name1) {
        this.commodityButton3Name1 = commodityButton3Name1 == null ? null : commodityButton3Name1.trim();
    }

    public String getCommodityButton3Link1() {
        return commodityButton3Link1;
    }

    public void setCommodityButton3Link1(String commodityButton3Link1) {
        this.commodityButton3Link1 = commodityButton3Link1 == null ? null : commodityButton3Link1.trim();
    }

    public String getCommodityButton3Name2() {
        return commodityButton3Name2;
    }

    public void setCommodityButton3Name2(String commodityButton3Name2) {
        this.commodityButton3Name2 = commodityButton3Name2 == null ? null : commodityButton3Name2.trim();
    }

    public String getCommodityButton3Link2() {
        return commodityButton3Link2;
    }

    public void setCommodityButton3Link2(String commodityButton3Link2) {
        this.commodityButton3Link2 = commodityButton3Link2 == null ? null : commodityButton3Link2.trim();
    }

    public String getCommodityButton3Name3() {
        return commodityButton3Name3;
    }

    public void setCommodityButton3Name3(String commodityButton3Name3) {
        this.commodityButton3Name3 = commodityButton3Name3 == null ? null : commodityButton3Name3.trim();
    }

    public String getCommodityButton3Link3() {
        return commodityButton3Link3;
    }

    public void setCommodityButton3Link3(String commodityButton3Link3) {
        this.commodityButton3Link3 = commodityButton3Link3 == null ? null : commodityButton3Link3.trim();
    }

    public String getHengBannerPic1() {
        return hengBannerPic1;
    }

    public void setHengBannerPic1(String hengBannerPic1) {
        this.hengBannerPic1 = hengBannerPic1 == null ? null : hengBannerPic1.trim();
    }

    public String getHengBannerLink1() {
        return hengBannerLink1;
    }

    public void setHengBannerLink1(String hengBannerLink1) {
        this.hengBannerLink1 = hengBannerLink1 == null ? null : hengBannerLink1.trim();
    }

    public String getHengBannerPic2() {
        return hengBannerPic2;
    }

    public void setHengBannerPic2(String hengBannerPic2) {
        this.hengBannerPic2 = hengBannerPic2 == null ? null : hengBannerPic2.trim();
    }

    public String getHengBannerLink2() {
        return hengBannerLink2;
    }

    public void setHengBannerLink2(String hengBannerLink2) {
        this.hengBannerLink2 = hengBannerLink2 == null ? null : hengBannerLink2.trim();
    }
}