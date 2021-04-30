package com.chenxinhao.runner.web.repository;


import com.chenxinhao.runner.web.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 陈鑫豪
 * @Time 2018/6/14
 */
public interface OrderRepository extends JpaRepository<Order,Long> {
}
