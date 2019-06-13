package com.briup.apps.ej.web.controller;


import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderExample;
import com.briup.apps.ej.bean.extend.OrderExtend;
import com.briup.apps.ej.service.IOrderService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @ApiOperation("查询所有订单信息(级联)")
    @GetMapping("Jquery")
    public Message query(Long customerId,
                         Long waiterId){
        List<OrderExtend> list =orderService.query(customerId,waiterId);
        return MessageUtil.success("success",list);
    }

    @ApiOperation("查询所有订单信息")
    @GetMapping("findAllOrder")
    public Message findAllOrder(){
        List<Order> list = orderService.findAllOrder();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询订单信息")
    @GetMapping("findOrderById")
    public Message findOrderById(@ApiParam(required = true) @RequestParam(value = "id") @NotNull long id){
        Order order = orderService.findOrderById(id);
        return MessageUtil.success("success",order);
    }

    @ApiOperation("模糊查询订单信息")
    @GetMapping("query")
    public Message query(Order order){
        List<Order> list = orderService.query(order);
        return MessageUtil.success("success",list);
    }

    @ApiOperation("保存或更新订单信息")
    @GetMapping("saveOrUpdateOrder")
    public Message saveOrUpdateOrder(Order order){
        try {
            orderService.saveOrUpdateOrder(order);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("通过id删除订单信息")
    @GetMapping("deleteOrderById")
    public Message deleteOrderById(@ApiParam(value = "主键",required = true) @RequestParam("id") @NotNull long id){
        try {
            orderService.deleteOrderById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
}