package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.vm.CustomerVM;

import java.util.List;

public interface ICustomerService {
    List<Customer> query(Customer customer);

    List<Customer> findAllCustomer();

    Customer findCustomerById(long id);

    void saveOrUpdateCustomer(Customer customer) throws Exception ;

    void deleteCustomerById(long id) throws Exception ;

    void recoverCustomerById(long id) throws  Exception ;

    void batchDeleteCustomer(long[] ids) throws Exception;

    List<CustomerVM> queryBasic(Long customerId);

}
