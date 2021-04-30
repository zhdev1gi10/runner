package com.chenxinhao.runner.web.service.impl;


import com.chenxinhao.runner.web.domain.Manager;
import com.chenxinhao.runner.web.repository.ManagerRepository;
import com.chenxinhao.runner.web.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 杨友奇
 * @Time 2018/6/7
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerRepository repository;

    @Override
    public Manager login(String username, String password) {
        return repository.findByUsernameAndPassword(username,password);
    }

    @Override
    public Manager detil(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Manager update(Long id, String newPassword) {
        Manager manager = repository.findOne(id);
        manager.setPassword(newPassword);
        return repository.save(manager);
    }
}
