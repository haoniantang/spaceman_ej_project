package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Waiter;

import java.util.List;

public interface IWaiterService {
    List<Waiter> query(Waiter waiter);

    List<Waiter> findAll();

    Waiter findById(long id);

    void saveOrUpdate(Waiter customer) throws Exception ;

    void deleteById(long id) throws Exception ;

    void recoverById(long id) throws Exception;
}