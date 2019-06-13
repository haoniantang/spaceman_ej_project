package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderExample;
import com.briup.apps.ej.bean.extend.OrderExtend;

import java.util.List;


public interface IOrderService {

    //
    List<OrderExtend> query(Long customerId,Long waiterId);

    List<Order> findAllOrder();

    List<Order> query(Order order);

    Order findOrderById(long id);

    void saveOrUpdateOrder(Order order) throws Exception ;

    void deleteOrderById(long id) throws Exception ;

    void batchDeleteOrder(long ids[]) throws Exception ;
}
