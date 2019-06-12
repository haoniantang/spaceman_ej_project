package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Waiter;

import java.util.List;

public interface IWaiterService {
    List<Waiter> query(Waiter waiter);

    List<Waiter> findAllWaiter();

    Waiter findWaiterById(long id);

    void saveOrUpdateWaiter(Waiter customer) throws Exception ;

    void deleteWaiterById(long id) throws Exception ;

    void recoverWaiterById(long id) throws Exception;

    void batchDeleteWaiter(long[] ids) throws Exception;
}