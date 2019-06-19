package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.OrderLine;
import com.briup.apps.ej.service.IOrderLineService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(description = "订单项管理相关接口")
@Validated
@RestController
@RequestMapping("/orderLine")
public class OrderLineController {
    @Autowired
    private IOrderLineService orderLineService;

    @ApiOperation("通过订单id查询订单项")
    @GetMapping("findOrderLineByOrderId")
    public Message findOrderLineByOrderId(
            @ApiParam(value = "order_id",required = true)
            @RequestParam(value = "order_id") Long order_id){
        if(order_id != null){
            List<OrderLine> findOrderLineList=orderLineService.findOrderLineByOrderId(order_id);
            if(findOrderLineList.size()==0){

                return MessageUtil.success("根据订单id查询订单项成功,该订单暂无订单项！");
            }else {
                return MessageUtil.success("根据订单id查询订单项成功！",findOrderLineList);
            }
        }else{
            return MessageUtil.error("查询失败:订单号获取失败！请重试！");
        }
    }

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
    public Message saveOrUpdateOrderLine(@Valid @ModelAttribute OrderLine orderLine){
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
