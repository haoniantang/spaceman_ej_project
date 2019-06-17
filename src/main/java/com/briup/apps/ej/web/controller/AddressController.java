package com.briup.apps.ej.web.controller;


import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.service.IAddressService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(description = "地址管理相关接口")
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;


    //查询所有的地址，返回是所有的地址
    @GetMapping("findAllAddress")
    @ApiOperation("查询所有地址信息")
    public Message findAllAddress(){
        List<Address> list=addressService.findAllAddress();
        return MessageUtil.success("success", list);
    }

    //根据顾客的id查询顾客的地址，返回是顾客所有的地址
    @ApiOperation("通过顾客id查询该顾客的所有地址信息")
    @GetMapping("findAdressByCuostomerId")
    public Message findAllAdressByCuostomerId(long id){
        List<Address> list=addressService.findAllAddressByCustomerId(id);
        if(list.isEmpty()){
            return MessageUtil.success("该用户没有地址，添加地址");
        }else{
            return MessageUtil.success("success", list);
        }
    }
    //根据表的id查询地址，返回是该id的地址
    @ApiOperation("通过id查询地址信息")
    @GetMapping("selectAddressById")
    public Message selectAddressById(long id){
        Address address=addressService.selectAddressById(id);
        return MessageUtil.success("success",address);
    }
    //根据表的id删除地址
    @ApiOperation("通过id删除地址信息")
    @GetMapping("deleteAddressById")
    public Message deleteAddressById(long id){
        try{
            addressService.deleteAddressById(id);
            return MessageUtil.success("删除地址成功！");
        }catch(Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("保存或者更新地址信息")
    //@PostMapping
    @PostMapping("saveOrUpdateAddress")
    public Message saveOrUpdateAddress(Address address){
        try{
            addressService.saveOrUpdateAddress(address);
            return MessageUtil.success("保存或者更新地址成功！");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    //增加新的地址
    @ApiOperation("添加新的地址信息")
    @GetMapping("insertAddress")
    public Message insertAddress(Address address){
        try{
            addressService.insertAddress(address);
            return MessageUtil.success("增加新的地址成功！");
        }catch(Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    //根据地址Id更新地址
    @ApiOperation("通过id更新地址信息")
    @GetMapping("updateAdddress")
    public Message updateById(Address address){
        try{
            addressService.updateAddress(address);
            return MessageUtil.success("更新地址成功！");
        }catch(Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

}
