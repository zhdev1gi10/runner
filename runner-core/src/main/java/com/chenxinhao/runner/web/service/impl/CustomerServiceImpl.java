package com.chenxinhao.runner.web.service.impl;


import com.chenxinhao.runner.web.repository.CustomerRepository;
import com.chenxinhao.runner.web.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.chenxinhao.runner.web.domain.Customer;

/**
 * @author 杨友奇
 * @Time 2018/6/5
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer register(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Boolean login1(String name, String password) {
        //判断用户是否存在
        if (repository.existsByUsername(name) == true) {
            //判断账户，密码是否正确
            if (repository.existsByUsernameAndPassword(name, password)) {
                System.out.println("账户密码正确");
                return true;

            } else {
                System.out.print("密码错误");
                return false;
            }
        } else {
            System.out.print("用户不存在");
            return false;
        }
    }

    @Override
    public Customer login(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Page<Customer> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Customer detail(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Customer update(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer applyToDistributor(Long id) {
        //通过id获取顾客信息
        Customer customer = repository.findOne(id);
        //修改申请状态
        customer.setApplyStatus(1);
        //保存修改
        return repository.save(customer);
    }

    @Override
    public Boolean confirmToDistributor(Long id, Integer applyStatus) throws Exception {
        //通过id获取顾客信息
        Customer customer = repository.findOne(id);
        /**
         * 修改申请状态
         * 当applyStatus为2 的时候表示申请通过，为9表示申请不通过
         */
        if (applyStatus == 2){
            customer.setApplyStatus(applyStatus);
            customer.setType(2);
            return true;
        }else if (applyStatus == 9){
            customer.setApplyStatus(applyStatus);
            return false;
        }else {
            throw new Exception("参数错误");
        }
    }


}
