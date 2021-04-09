package com.chenxinhao.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//scanBasePackages = "com.chenxinhao.runner"启动类改为扫描到com.chenxinhao.runner包下面
@SpringBootApplication
public class RunnerApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(RunnerApiApplication.class, args);
    }

}
