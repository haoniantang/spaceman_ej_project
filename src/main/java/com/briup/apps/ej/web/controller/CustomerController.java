package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.service.ICustomerService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Customer user) {
        List<Customer> list = customerService.query(user);
        return MessageUtil.success("条件查询顾客成功！", list);
    }


    @GetMapping("findAll")
    public Message findAll() {
        List<Customer> list = customerService.findAll();
        return MessageUtil.success("查询所有顾客成功！", list);
    }

    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public Message findById(
            @ApiParam(value = "主键", required = true)
            @RequestParam(value = "id") long id) {
        Customer customer = customerService.findById(id);
        return MessageUtil.success("通过id查询顾客成功！", customer);
    }

    @ApiOperation("保存或更新用户信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Customer customer) {
        try {
            customerService.saveOrUpdate(customer);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("通过id删除顾客信息")
    @GetMapping("deleteById")
    public Message deleteById(@ApiParam(value = "主键", required = true) @RequestParam("id") long id) {
        try {
            //因为数据库中涉及到级联删除，所以删除用户只需要将status改为0
            customerService.deleteById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
}
