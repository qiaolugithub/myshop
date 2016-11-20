package net.jeeshop.services.front.discountDetail.dao.impl;

import net.jeeshop.core.dao.BaseDao;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.services.front.discountDetail.bean.DiscountDetail;
import net.jeeshop.services.front.discountDetail.dao.DiscountDetailDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("discountDetailDaoFront")
public class DiscountDetailDaoImpl implements DiscountDetailDao {
    @Resource
    private BaseDao dao;

    public void setDao(BaseDao dao) {
        this.dao = dao;
    }

    public PagerModel selectPageList(DiscountDetail e) {
        return dao.selectPageList("front.discountDetail.selectPageList",
                "front.discountDetail.selectPageCount", e);
    }



    public List selectList(DiscountDetail e) {
        return dao.selectList("front.discountDetail.selectList", e);
    }

    public DiscountDetail selectOne(DiscountDetail e) {
        return (DiscountDetail) dao.selectOne("front.discountDetail.selectOne", e);
    }

    public int delete(DiscountDetail e) {
        return dao.delete("front.discountDetail.deleteById", e);
    }

    public int update(DiscountDetail e) {
        return dao.update("front.discountDetail.update", e);
    }

    public int deletes(String[] ids) {
        DiscountDetail e = new DiscountDetail();
        for (int i = 0; i < ids.length; i++) {
            e.setId(ids[i]);
            delete(e);
        }
        return 0;
    }

    public int insert(DiscountDetail e) {
        return dao.insert("front.discountDetail.insert", e);
    }

    public int deleteById(int id) {
        return dao.delete("front.discountDetail.deleteById", id);
    }

    public DiscountDetail selectById(String id) {
        return (DiscountDetail) dao.selectOne("front.discountDetail.selectById", id);
    }

    public void initAlldiscountDetail(DiscountDetail discountDetail) {
        dao.update("front.discountDetail.initAlldiscountDetail",discountDetail);
    }


    @Override
    public Integer getHasCount(Map map) {
        return dao.getCount("front.discountDetail.getHasCount", map);
    }
}
