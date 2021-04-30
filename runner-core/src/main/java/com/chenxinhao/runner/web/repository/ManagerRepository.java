package com.chenxinhao.runner.web.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.chenxinhao.runner.web.domain.Manager;

/**
 * @author 陈鑫豪
 * @Time 2018/6/14
 */
public interface ManagerRepository extends JpaRepository<Manager,Long> {

    public Manager findByUsernameAndPassword(String username, String password);
}
