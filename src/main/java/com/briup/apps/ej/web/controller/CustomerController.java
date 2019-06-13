package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.service.ICustomerService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @ApiOperation("模糊查询顾客信息")
    @GetMapping("query")
    public Message query(Customer customer){
        List<Customer> list = customerService.query(customer);
        return MessageUtil.success("success",list);
    }

    @ApiOperation("查询所有顾客信息")
    @GetMapping("findAllCustomer")
    public Message findAllCustomer(){
        List<Customer> list = customerService.findAllCustomer();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询顾客信息")
    @GetMapping("findCustomerById")
    public Message findCustomerById(
            @ApiParam(value = "主键",required = true)
            @RequestParam(value = "id") long id){
        Customer customer = customerService.findCustomerById(id);
        return MessageUtil.success("success",customer);
    }

    @ApiOperation("保存或更新顾客信息")
    @PostMapping("saveOrUpdateCustomer")
    public Message saveOrUpdateCustomer(Customer customer){
        try {
            customerService.saveOrUpdateCustomer(customer);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("通过id删除顾客信息")
    @GetMapping("deleteCustomerById")
    public Message deleteCustomerById(@ApiParam(value = "主键",required = true) @RequestParam("id") long id){
        try {
            customerService.deleteCustomerById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("通过id恢复顾客信息")
    @GetMapping("recoverCustomerById")
    public Message recoverCustomerById(@ApiParam(value = "主键",required = true) @RequestParam("id") long id){
        try {
            customerService.recoverCustomerById(id);
            return MessageUtil.success("恢复成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("批量删除顾客信息")
    @PostMapping("batchDeleteCustomer")
    public Message batchDeleteCustomer( long[] ids) throws Exception{
        customerService.batchDeleteCustomer(ids);
        return MessageUtil.success("批量删除成功");
    }

}