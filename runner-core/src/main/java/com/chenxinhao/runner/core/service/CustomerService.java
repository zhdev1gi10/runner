package com.chenxinhao.runner.core.service;

import com.chenxinhao.runner.core.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomerService {
    /**
     * 注册
     */
    public Customer register(Customer customer);
    /**
     * 登陆
     */
    public Boolean login(String name, String password);

    /**
     * 顾客列表
     */
    public Page<Customer> list(Pageable pageable);

    /**
     * 顾客详情
     */
    public Customer detail(Long id);

    /**
     * 修改顾客
     */
    public Customer update(Customer customer);

    /**
     * 确认配送资格
     */
    public Customer uptype(Integer type);


}
