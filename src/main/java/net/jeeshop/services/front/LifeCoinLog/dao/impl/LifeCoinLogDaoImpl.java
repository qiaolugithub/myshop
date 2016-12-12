package net.jeeshop.services.front.lifecoinlog.dao.impl;

import net.jeeshop.core.dao.BaseDao;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.services.front.lifecoinlog.bean.LifeCoinLog;
import net.jeeshop.services.front.lifecoinlog.dao.LifeCoinLogDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Qiao on 2016/12/11.
 */
@Repository("lifeCoinLogDaoFront")
public class LifeCoinLogDaoImpl implements LifeCoinLogDao {
    @Resource
    private BaseDao dao;

    public void setDao(BaseDao dao) {
        this.dao = dao;
    }

    public PagerModel selectPageList(LifeCoinLog e) {
        return dao.selectPageList("front.lifeCoinLog.selectPageList",
                "front.lifeCoinLog.selectPageCount", e);
    }

    public List selectList(LifeCoinLog e) {
        return dao.selectList("front.lifeCoinLog.selectList", e);
    }

    public LifeCoinLog selectOne(LifeCoinLog e) {
        return (LifeCoinLog) dao.selectOne("front.lifeCoinLog.selectOne", e);
    }

    public int delete(LifeCoinLog e) {
        return dao.delete("front.lifeCoinLog.delete", e);
    }

    public int update(LifeCoinLog e) {
        return dao.update("front.lifeCoinLog.update", e);
    }

    public int deletes(String[] ids) {
        LifeCoinLog e = new LifeCoinLog();
        for (int i = 0; i < ids.length; i++) {
            e.setId(ids[i]);
            delete(e);
        }
        return 0;
    }

    public int insert(LifeCoinLog e) {
        return dao.insert("front.lifeCoinLog.insert", e);
    }

    public int deleteById(int id) {
        return dao.delete("front.lifeCoinLog.deleteById", id);
    }

    public LifeCoinLog selectById(String id) {
        return (LifeCoinLog) dao.selectOne("account.selectById", id);
    }
}

