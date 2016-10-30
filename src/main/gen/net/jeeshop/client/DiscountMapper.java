package net.jeeshop.client;

import java.util.List;
import net.jeeshop.model.Discount;
import net.jeeshop.model.DiscountExample;

public interface DiscountMapper {
    int countByExample(DiscountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Discount record);

    int insertSelective(Discount record);

    List<Discount> selectByExample(DiscountExample example);

    Discount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Discount record);

    int updateByPrimaryKey(Discount record);
}