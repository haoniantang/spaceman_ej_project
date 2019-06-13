package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderExample;
import com.briup.apps.ej.dao.OrderMapper;
import com.briup.apps.ej.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private OrderMapper orderMapper;


    @Override
    public List<Order> findAllOrder() {
        //创建空模块
        OrderExample example = new OrderExample();
        return orderMapper.selectByExample(example);
    }

    @Override
    public Order findOrderById(long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Order> query(Order order) {
        // 创建空模板
        OrderExample example = new OrderExample();
        // 在模板中添加条件
        if(order.getId()!=null){
            example.createCriteria().andIdEqualTo(order.getId());
        }
        if(order.getAddressId()!=null){
            example.createCriteria().andAddressIdEqualTo(order.getAddressId());
        }
        if(order.getCustomerId()!=null){
            example.createCriteria().andCustomerIdEqualTo(order.getAddressId());
        }
        if(order.getWaiterId()!=null){
            example.createCriteria().andWaiterIdEqualTo(order.getWaiterId());
        }
        if(order.getOrderTime()!=null){
            example.createCriteria().andOrderTimeEqualTo(order.getOrderTime());
        }
        if(order.getTotal()!=null){
            example.createCriteria().andTotalEqualTo(order.getTotal());
        }

        return orderMapper.selectByExample(example);
    }

    @Override
    public void saveOrUpdateOrder(Order order) throws Exception {
        if(order.getId() == null){
            // 初始化属性
            orderMapper.insert(order);
        } else {
            orderMapper.updateByPrimaryKey(order);
        }
    }

    @Override
    public void deleteOrderById(long id) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(id);
        if(order == null){
            throw new Exception("要删除的订单不存在");
        } else {
            orderMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void batchDeleteOrder(long[] ids) throws Exception {
         for(long id : ids){
                 orderMapper.deleteByPrimaryKey(id);
         }
    }
}
