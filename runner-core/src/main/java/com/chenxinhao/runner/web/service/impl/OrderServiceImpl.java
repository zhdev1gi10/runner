package com.chenxinhao.runner.web.service.impl;


import com.chenxinhao.runner.web.domain.Order;
import com.chenxinhao.runner.web.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.chenxinhao.runner.web.domain.Customer;
import com.chenxinhao.runner.web.domain.Manager;
import com.chenxinhao.runner.web.service.OrderService;
import java.util.Date;

/**
 * @author 杨友奇
 * @Time 2018/6/7
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Order create(Order order, Long customerId) {
        //谁下单，那个时间下单
        Customer customer = new Customer(customerId);


        order.setStatus(1);
        order.setCreator(customer);
        order.setCreateTime(new Date());

        return orderRepository.save(order);
    }

    @Override
    public Page<Order> list(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Order get(Long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order confirmByCustomer(Long orderId) {
        //由客户确认订单，订单状态改为5：已收货
        Order order = orderRepository.findOne(orderId);

        order.setStatus(5);
        order.setCreateTime(new Date());
        return orderRepository.save(order);
    }

    @Override
    public Order evaluate(Long orderId, String evaluateContent) {
        //评价订单，订单状态改为6：已评价
        Order order = orderRepository.findOne(orderId);

        order.setStatus(6);
        order.setCreateTime(new Date());
        order.setEvaluateContent(evaluateContent);
        return orderRepository.save(order);
    }

    @Override
    public Order claim(Long orderId) {
        //配送员认领订单，订单状态改为3：配送中
        Order order = orderRepository.findOne(orderId);


        order.setStatus(3);
        order.setCreateTime(new Date());
        return orderRepository.save(order);
    }

    @Override
    public Order confirmByDistributor(Long orderId) {
        //由配送员确认收货，订单状态改为4：已送达
        Order order = orderRepository.findOne(orderId);

        order.setStatus(4);
        order.setSendToTime(new Date());
        return orderRepository.save(order);
    }

    @Override
    public Order modify(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order assign(Long orderId, Long assignorId, Long designeeId) {
        Manager manager = new Manager(assignorId);

        Customer customer = new Customer(designeeId);

        //指派订单，订单状态改为2：已指派
        Order order = orderRepository.findOne(orderId);
        order.setStatus(2);
        order.setAssignor(manager);
        order.setDesignee(customer);
        order.setAssignTime(new Date());

        return orderRepository.save(order);
    }
}
