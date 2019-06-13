package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.extend.OrderExtend;

import java.util.List;


public interface IOrderService {

    List<Order> findAllOrder();

    List<OrderExtend> query(Long customerId,Long waiterId);

    Order findOrderById(long id);

    void saveOrUpdateOrder(Order order) throws Exception ;

    void deleteOrderById(long id) throws Exception ;

    void batchDeleteOrder(long ids[]) throws Exception ;
}
