package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Address;

import java.util.List;

public interface IAddressService {
    List<Address> findAllAddress();

    List<Address> findAllAddressByCustomerId(long id);

    Address selectAddressById(long id);

    void deleteAddressById(long id) throws Exception;

    void insertAddress(Address address) throws Exception;

    void updateAddress(Address address) throws Exception;

}
