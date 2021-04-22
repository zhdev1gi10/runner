package com.chenxinhao.runner.core.repository;

import com.chenxinhao.runner.core.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order,Long> {
}
