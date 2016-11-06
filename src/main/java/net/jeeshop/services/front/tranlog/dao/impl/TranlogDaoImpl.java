package net.jeeshop.services.front.tranlog.dao.impl;


import net.jeeshop.core.dao.BaseDao;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.services.front.tranlog.bean.Tranlog;
import net.jeeshop.services.front.tranlog.dao.TranlogDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class TranlogDaoImpl implements TranlogDao{

    @Resource
    private BaseDao dao;

    public void setDao(BaseDao dao) {
        this.dao = dao;
    }

    public PagerModel selectPageList(Tranlog e) {
        return dao.selectPageList("front.tranlog.selectPageList",
                "front.tranlog.selectPageCount", e);
    }

    public List selectList(Tranlog e) {
        return dao.selectList("front.tranlog.selectList", e);
    }

    public Tranlog selectOne(Tranlog e) {
        return (Tranlog) dao.selectOne("front.tranlog.selectOne", e);
    }

    public int delete(Tranlog e) {
        return dao.delete("front.tranlog.delete", e);
    }

    public int update(Tranlog e) {
        return dao.update("front.tranlog.update", e);
    }

    public int deletes(String[] ids) {
        Tranlog e = new Tranlog();
        for (int i = 0; i < ids.length; i++) {
            e.setId(ids[i]);
            delete(e);
        }
        return 0;
    }

    public int insert(Tranlog e) {
        return dao.insert("front.tranlog.insert", e);
    }

    public int deleteById(int id) {
        return dao.delete("front.tranlog.deleteById", id);
    }

    @Override
    public Tranlog selectById(String id) {
        return null;
    }


}