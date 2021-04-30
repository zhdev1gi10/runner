package com.chenxinhao.runner.web.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.chenxinhao.runner.web.domain.Customer;

/**
 * 顾客服务类
 *
 * @author 陈鑫豪
 * @Time 2018/6/5
 */
public interface CustomerService {
    /**
     * 注册
     */
    public Customer register(Customer customer);
    /**
     * 登陆
     */
    public Boolean login1(String name, String password);

    /**
     * 顾客登录
     * @param username
     * @param password
     * @return
     */
    public Customer login(String username, String password);
    /**
     * 顾客列表(分页)
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
     * 申请配送资格
     * @param id
     * @return
     */
    public Customer applyToDistributor(Long id);

    /**
     * 确认配送资格
     * @param id
     * @param applyStatus(2:通过，9：不通过)
     * @return
     */
    public Boolean  confirmToDistributor(Long id, Integer applyStatus)throws Exception;


}
