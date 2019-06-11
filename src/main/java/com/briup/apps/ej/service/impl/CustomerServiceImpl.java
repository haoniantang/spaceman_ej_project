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

    @Override
    public List<Customer> findAll() {
        CustomerExample example = new CustomerExample();
        return customerMapper.selectByExample(example);
    }

    @Override
    public Customer findById(long id) {
        // 调用mapper层代码完成查询操作
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Customer customer) throws Exception {
        if(customer.getId() == null){
            // 初始化属性
            customer.setStatus("1");
            customerMapper.insert(customer);
        } else {
            customerMapper.updateByPrimaryKey(customer);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        Customer customer = customerMapper.selectByPrimaryKey(id);
        if(customer == null){
            throw new Exception("要删除的顾客不存在");
        } else {
            //status为1表示正常状态，status设置为0则表示删除或封禁
            customer.setStatus("0");
            customerMapper.updateByPrimaryKey(customer);
        }
    }

    @Override
    public void recoverById(long id) throws Exception {
        Customer customer = customerMapper.selectByPrimaryKey(id);
        if(customer == null){
            throw new Exception("要恢复的顾客不存在");
        } else {
            //status为1表示正常状态，status设置为0则表示删除或封禁
            customer.setStatus("1");
            customerMapper.updateByPrimaryKey(customer);
        }
    }


}
