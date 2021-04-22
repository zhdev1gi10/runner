package com.chenxinhao.runner.core.repository;

import com.chenxinhao.runner.core.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
    /**
     * 查询用户，返回为布尔类型
     */
    public Boolean existsByUsername(String userName);

    /**
     * 查询账户密码，返回为布尔类型
     */
    public Boolean existsByUsernameAndPassword(String userName, String password);
}
