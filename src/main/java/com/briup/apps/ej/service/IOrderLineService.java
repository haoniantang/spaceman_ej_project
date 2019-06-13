package com.briup.apps.ej.service;


import com.briup.apps.ej.bean.OrderLine;

import java.util.List;

public interface IOrderLineService {
    List<OrderLine> findAllOrderLine();

    List<OrderLine> query(OrderLine orderLine);

    OrderLine findOrderLineById(long id);

    void saveOrUpdateOrderLine(OrderLine orderLine) throws Exception ;

    void deleteOrderLineById(long id) throws Exception ;

    void batchDeleteOrderLine(long ids[]) throws Exception ;
}
