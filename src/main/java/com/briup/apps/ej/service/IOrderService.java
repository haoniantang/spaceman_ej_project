package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.extend.OrderExtend;
import com.briup.apps.ej.bean.vm.OrderAndOrderLineVM;
import com.briup.apps.ej.bean.vm.OrderVM;

import java.util.List;


public interface IOrderService {
    void save(OrderAndOrderLineVM order) throws Exception;

    List<OrderVM> queryBasic(Long customerId, Long waiterId);

    List<Order> findAllOrder();

    List<OrderExtend> query(Long customerId,Long waiterId);

    Order findOrderById(long id);

    void saveOrUpdateOrder(Order order) throws Exception ;

    void deleteOrderById(long id) throws Exception ;

    void batchDeleteOrder(long ids[]) throws Exception ;
}
