package com.chenxinhao.runner.core.service.impl;


import com.chenxinhao.runner.core.domain.Customer;
import com.chenxinhao.runner.core.repository.CustomerRepository;
import com.chenxinhao.runner.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer register(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Boolean login(String name, String password) {
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
    public Page<Customer> list(Pageable pageable) {
        return null;
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
    public Customer uptype(Integer type) {
        Customer customer = new Customer();
        customer.setType(type);
        return repository.save(customer);
    }
}
