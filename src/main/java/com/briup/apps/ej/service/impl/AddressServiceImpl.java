package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.AddressExample;
import com.briup.apps.ej.dao.AddressMapper;
import com.briup.apps.ej.service.IAdressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements IAdressService {
    @Resource
    private AddressMapper addressMapper;

    @Override
    public List<Address> findAll() {
        AddressExample example=new AddressExample();
        return addressMapper.selectByExample(example);
    }

    @Override
    public List<Address> findCustomerAllAddress(long id) {
        AddressExample example=new AddressExample();
        AddressExample.Criteria criteria=example.createCriteria();
        criteria.andCustomerIdEqualTo(id);
        return addressMapper.selectByExample(example);
    }

    @Override
    public Address selectById(long id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(long id) throws Exception{
        Address address=addressMapper.selectByPrimaryKey(id);
        if(address == null){
            throw new Exception("要删除的地址不存在！");
        }else{
            addressMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void insert(Address address) throws Exception {
        Address address1=addressMapper.selectByPrimaryKey(address.getId());
        if(address1==null) {
            addressMapper.insert(address);
        }else{
            throw new Exception("插入的Id已占用！");
        }
    }




}
