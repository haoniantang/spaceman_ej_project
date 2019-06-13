package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.OrderLine;
import com.briup.apps.ej.service.IOrderLineService;
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
@RequestMapping("/orderLine")
public class OrderLineController {
    @Autowired
    private IOrderLineService orderLineService;

    @ApiOperation("查询所有订单项信息")
    @GetMapping("findAllOrderLine")
    public Message findAllOrderLine(){
        List<OrderLine> list = orderLineService.findAllOrderLine();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询订单项信息")
    @GetMapping("findOrderLineById")
    public Message findOrderLineById(@ApiParam(required = true) @RequestParam(value = "id") @NotNull long id){
        OrderLine orderLine = orderLineService.findOrderLineById(id);
        return MessageUtil.success("success",orderLine);
    }

    @ApiOperation("模糊查询订单项信息")
    @GetMapping("query")
    public Message query(OrderLine orderLine){
        List<OrderLine> list = orderLineService.query(orderLine);
        return MessageUtil.success("success",list);
    }

    @ApiOperation("保存或更新订单项信息")
    @GetMapping("saveOrUpdateOrderLine")
    public Message saveOrUpdateOrderLine(OrderLine orderLine){
        try {
            orderLineService.saveOrUpdateOrderLine(orderLine);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("通过id删除订单项信息")
    @GetMapping("deleteOrderLineById")
    public Message deleteOrderLineById(@ApiParam(value = "主键",required = true) @RequestParam("id") @NotNull long id){
        try {
            orderLineService.deleteOrderLineById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
}
