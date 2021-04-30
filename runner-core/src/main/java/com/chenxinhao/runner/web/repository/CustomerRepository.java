package com.chenxinhao.runner.web.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.chenxinhao.runner.web.domain.Customer;

/**
 * @author 陈鑫豪
 * @Time 2018/6/14
 */
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    /**
     * 查询用户，返回为布尔类型
     */
    public Boolean existsByUsername(String userName);

    /**
     * 查询账户密码，返回为布尔类型
     */
    public Boolean existsByUsernameAndPassword(String userName, String password);

    public Customer findByUsernameAndPassword(String username, String password);
}
