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
}
