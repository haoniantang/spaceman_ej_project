package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Address;

import java.util.List;

public interface IAdressService {
    List<Address> findAll();

    List<Address> findCustomerAllAddress(long id);

    Address selectById(long id);

    void deleteById(long id) throws Exception;

    void insert(Address address) throws Exception;



}
