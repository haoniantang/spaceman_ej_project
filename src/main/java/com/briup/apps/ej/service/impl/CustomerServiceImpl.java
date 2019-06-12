package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.CustomerExample;
import com.briup.apps.ej.dao.CustomerMapper;
import com.briup.apps.ej.service.ICustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    // 自动注入mapper实例
    @Resource
    private CustomerMapper customerMapper;

    //模糊查询顾客
    @Override
    public List<Customer> query(Customer customer) {
        // 创建空模板
        CustomerExample example = new CustomerExample();
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

        return customerMapper.selectByExample(example);
    }

    //查询所有顾客信息
    @Override
    public List<Customer> findAllCustomer() {
        CustomerExample example = new CustomerExample();
        return customerMapper.selectByExample(example);
    }

    //根据id查询顾客信息
    @Override
    public Customer findCustomerById(long id) {
        // 调用mapper层代码完成查询操作
        return customerMapper.selectByPrimaryKey(id);
    }

    //插入或更新顾客信息
    @Override
    public void saveOrUpdateCustomer(Customer customer) throws Exception {
        if(customer.getId() == null){
            // 初始化属性
            customer.setStatus("1");
            customerMapper.insert(customer);
        } else {
            customerMapper.updateByPrimaryKey(customer);
        }
    }

    //根据id删除顾客，设置顾客的status为0
    @Override
    public void deleteCustomerById(long id) throws Exception {
        Customer customer = customerMapper.selectByPrimaryKey(id);
        if(customer == null){
            throw new Exception("要删除的顾客不存在");
        } else {
            //status为1表示正常状态，status设置为0则表示删除或封禁
            customer.setStatus("0");
            customerMapper.updateByPrimaryKey(customer);
        }
    }

    //恢复顾客的使用权限
    @Override
    public void recoverCustomerById(long id) throws Exception {
        Customer customer = customerMapper.selectByPrimaryKey(id);
        if(customer == null){
            throw new Exception("要恢复的顾客不存在");
        } else {
            //status为1表示正常状态，status设置为0则表示删除或封禁
            customer.setStatus("1");
            customerMapper.updateByPrimaryKey(customer);
        }
    }

    //批量删除顾客，即设置使用权不可用
    @Override
    public void batchDeleteCustomer(long[] ids) throws Exception {
        for(long id :ids){
            Customer customer = customerMapper.selectByPrimaryKey(id);
            //设置customer的status为0，表示该顾客处于不可用状态
            customer.setStatus("0");
            customerMapper.updateByPrimaryKey(customer);
        }
    }

}
