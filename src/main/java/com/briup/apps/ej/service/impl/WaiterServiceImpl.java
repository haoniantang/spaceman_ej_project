package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Waiter;
import com.briup.apps.ej.bean.WaiterExample;
import com.briup.apps.ej.dao.WaiterMapper;
import com.briup.apps.ej.service.IWaiterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WaiterServiceImpl implements IWaiterService {
    @Resource
    private WaiterMapper waiterMapper;

    @Override
    public List<Waiter> query(Waiter customer) {
        // 创建空模板
        WaiterExample example = new WaiterExample();
        // 在模板中添加条件
        if(customer.getRealname()!=null){
            example
                    .createCriteria()
                    .andRealnameLike("%"+customer.getRealname()+"%");
        }
        if(customer.getTelephone()!=null){
            example
                    .createCriteria()
                    .andTelephoneLike("%"+customer.getTelephone()+"%");
        }

        return waiterMapper.selectByExample(example);
    }

    @Override
    public List<Waiter> findAll() {
        WaiterExample example = new WaiterExample();
        return waiterMapper.selectByExample(example);
    }

    @Override
    public Waiter findById(long id) {
        // 调用mapper层代码完成查询操作
        return waiterMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Waiter customer) throws Exception {
        if(customer.getId() == null){
            // 初始化属性
            customer.setStatus("1");
            waiterMapper.insert(customer);
        } else {
            waiterMapper.updateByPrimaryKey(customer);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        Waiter waiter = waiterMapper.selectByPrimaryKey(id);
        if(waiter == null){
            throw new Exception("要删除的顾客不存在");
        } else {
            waiterMapper.deleteByPrimaryKey(id);
        }
    }
}