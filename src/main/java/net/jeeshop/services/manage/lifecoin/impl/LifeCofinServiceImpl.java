package net.jeeshop.services.manage.lifecoin.impl;

import net.jeeshop.core.ServersManager;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.core.util.ExcelExportHelper;
import net.jeeshop.services.manage.lifecoin.LifeCoinService;
import net.jeeshop.services.manage.lifecoin.bean.LifeCoin;
import net.jeeshop.services.manage.lifecoin.dao.LifeCoinDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qiao on 2016/12/10.
 */
@Service("lifeCofinServiceManage")
public class LifeCofinServiceImpl extends ServersManager<LifeCoin, LifeCoinDao> implements
        LifeCoinService {
    @Autowired
    @Override
    public void setDao(LifeCoinDao LifeCoinDao) {
        this.dao = LifeCoinDao;
    }

 /*   @Override
    public PagerModel selectPageListAllUserLifeCoin(LifeCoin e) {
        return dao.selectPageListAllUserLifeCoin(e);
    }*/

    @Override
    public LifeCoin getSumAndCount() {
        return dao.getSumAndCount();
    }

    @Override
    public String exportAllUserLifeCoinList() {
        String filePath = this.getClass().getResource("/").getPath();
        String fileName = "data";
        List<LifeCoin> list = dao.exportAllUserLifeCoinList();
        ExcelExportHelper excel = new ExcelExportHelper();
        List<Object> listdata = new ArrayList<Object>();
        for (LifeCoin obj : list) {
            obj.setAccount(obj.getAccount() != null ? obj.getAccount() : "");
            obj.setNickname(obj.getNickname() != null ? obj.getNickname() : "");
            obj.setEmail(obj.getEmail() != null ? obj.getEmail(): "");
            obj.setCoincount(obj.getCoincount());
            obj.setCoinaddress(obj.getCoinaddress() != null ? obj.getCoinaddress(): "");
            if (obj.getIslock() != null) {
                if (obj.getIslock().equals("1")) {
                    obj.setIsLocked("已锁定");
                }  else {
                    obj.setIsLocked("正常");
                }
            }
            listdata.add(obj);
        }
        String[] header = {"账号", "昵称", "邮箱", "燊活币余额", "地址", "状态"};
        String[] properties = {"account", "nickname", "email", "coincount", "coinaddress",  "isLocked"};
        excel.exportExcelForBigDataAndSave(header, properties, listdata, fileName, "0002", filePath, fileName);
        return fileName + ".xls";
    }
}
