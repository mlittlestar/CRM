package com.briup.crm.dao.mapperInterface;

import com.briup.crm.common.bean.OrdersLine;
import com.briup.crm.common.bean.OrdersLineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersLineMapper {
    int countByExample(OrdersLineExample example);

    int deleteByExample(OrdersLineExample example);

    int deleteByPrimaryKey(Long oddId);

    int insert(OrdersLine record);

    int insertSelective(OrdersLine record);

    List<OrdersLine> selectByExample(OrdersLineExample example);

    OrdersLine selectByPrimaryKey(Long oddId);

    int updateByExampleSelective(@Param("record") OrdersLine record, @Param("example") OrdersLineExample example);

    int updateByExample(@Param("record") OrdersLine record, @Param("example") OrdersLineExample example);

    int updateByPrimaryKeySelective(OrdersLine record);

    int updateByPrimaryKey(OrdersLine record);
}