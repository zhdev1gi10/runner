package com.chenxinhao.runner.core.repository;

import com.chenxinhao.runner.core.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    public Manager findByUsernameAndPassword(String username, String password);
}
