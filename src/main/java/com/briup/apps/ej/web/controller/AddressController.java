package com.briup.apps.ej.web.controller;


import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.service.IAdressService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAdressService addressService;


    //查询所有的地址，返回是所有的地址
    @GetMapping("findAll")
    public Message findAll(){
        List<Address> list=addressService.findAll();
        return MessageUtil.success("success", list);
    }

    //根据顾客的id查询顾客的地址，返回是顾客所有的地址
    @GetMapping("findCustomerAllAdress")
    public Message findCuostomerAllAdress(long id){
        List<Address> list=addressService.findCustomerAllAddress(id);
        if(list.isEmpty()){
            return MessageUtil.success("该用户没有地址，添加地址");
        }else{
            return MessageUtil.success("success", list);
        }
    }
    //根据表的id查询地址，返回是该id的地址
    @GetMapping("selectById")
    public Message selectById(long id){
        Address address=addressService.selectById(id);
        return MessageUtil.success("success",address);
    }
    //根据表的id删除地址
    @GetMapping("deleteById")
    public Message deleteById(long id){
        try{
            addressService.deleteById(id);
            return MessageUtil.success("删除地址成功！");
        }catch(Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    //增加新的地址
    @GetMapping("insert")
    public Message insert(Address address){
        try{
            addressService.insert(address);
            return MessageUtil.success("增加新的地址成功！");
        }catch(Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    //根据地址Id更新地址
    @GetMapping("updateById")
    public Message updateById(Address address){
        try{
            addressService.updateByPrimaryKey(address);
            return MessageUtil.success("更新地址成功！");
        }catch(Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

}
