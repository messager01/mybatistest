package com.spx.mapper;

import com.spx.entities.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * create by Shipeixin on 2020/3/30 21:35
 */
@Mapper
public interface OrderMapper {

    //  查询所有订单
    List<Order> getAllOrder();

    Order getOrderWithId(Integer id);

    // 保存订单
    void insertOrder(Order order);

    // 破除主键关系
    @Update("update `order` set cust_id = null where order_id = #{id}")
    void breakRelation(Integer id);

    // 删除订单
    @Delete("delete from `order` where order_id = #{id}")
    void deleteOrderById(Integer id);
}
