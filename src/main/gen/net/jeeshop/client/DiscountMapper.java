package net.jeeshop.client;

import java.util.List;
import net.jeeshop.model.Discount;

public interface DiscountMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Discount record);

    int insertSelective(Discount record);


    Discount selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Discount record);
}