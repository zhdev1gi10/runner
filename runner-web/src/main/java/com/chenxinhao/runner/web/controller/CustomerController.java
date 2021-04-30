package com.chenxinhao.runner.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chenxinhao.runner.web.domain.Customer;
import com.chenxinhao.runner.web.service.CustomerService;

/**
 * @author 陈鑫豪
 * @Time 2018/6/14
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //http://localhost:8089/c/login
    @GetMapping("/login")
    public String login(){
        return "customer/login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){
        Customer customer = customerService.login(username, password);

        if (customer == null){
            //登录不成功,跳转到错误页面
            return "customer/error";
        }else{
            //把用户数据存放session中

            //登录成功，跳转到首页
            return "customer/index";
        }

    }

}
