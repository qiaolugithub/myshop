package net.jeeshop.services.manage.lifecoin.dao.impl;

import net.jeeshop.core.dao.BaseDao;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.services.manage.lifecoin.bean.LifeCoin;
import net.jeeshop.services.manage.lifecoin.dao.LifeCoinDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Qiao on 2016/12/10.
 */
@Repository("lifeCoinDaoManage")
public class LifeCoinDaoImpl implements LifeCoinDao {
    @Resource
    private BaseDao dao;

    public void setDao(BaseDao dao) {
        this.dao = dao;
    }

    public PagerModel selectPageList(LifeCoin e) {
        return dao.selectPageList("manage.lifeCoin.selectAllUserLifeCoinList",
                "manage.lifeCoin.selectAllUserLifeCoinCount", e);
    }

/*
    public PagerModel selectPageListAllUserLifeCoin(LifeCoin e) {
        return dao.selectPageList("manage.lifeCoin.selectAllUserLifeCoinList",
                "manage.lifeCoin.selectAllUserLifeCoinCount", e);
    }*/

    public List selectList(LifeCoin e) {
        return dao.selectList("manage.lifeCoin.selectList", e);
    }

    public LifeCoin selectOne(LifeCoin e) {
        return (LifeCoin) dao.selectOne("manage.lifeCoin.selectOne", e);
    }

    public int delete(LifeCoin e) {
        return dao.delete("manage.lifeCoin.delete", e);
    }

    public int update(LifeCoin e) {
        return dao.update("manage.lifeCoin.update", e);
    }

    public int deletes(String[] ids) {
        LifeCoin e = new LifeCoin();
        for (int i = 0; i < ids.length; i++) {
            e.setId(ids[i]);
            delete(e);
        }
        return 0;
    }

    public int insert(LifeCoin e) {
        return dao.insert("manage.lifeCoin.insert", e);
    }

    public int deleteById(int id) {
        return dao.delete("manage.lifeCoin.deleteById", id);
    }

    public LifeCoin selectById(String id) {
        return (LifeCoin) dao.selectOne("manage.lifeCoin.selectById", id);
    }

    public LifeCoin getSumAndCount(){
        return (LifeCoin) dao.selectOne("manage.lifeCoin.getSumAndCount");
    }
}

