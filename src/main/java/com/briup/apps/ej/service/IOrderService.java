package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Order;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IOrderService {
    List<Order> findAll();

    List<Order> query(Order order);

    Order findById(long id);

    void saveOrUpdate(Order order) throws Exception ;

    void deleteById(long id) throws Exception ;
}
