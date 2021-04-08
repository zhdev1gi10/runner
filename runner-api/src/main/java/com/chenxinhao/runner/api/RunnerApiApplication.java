package com.chenxinhao.runner.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//scanBasePackages = "com.yangyouqi.runner"启动类改为扫描到com.yangyouqi.runner包下面
@SpringBootApplication(scanBasePackages = "com.chenxinhao.runner")
public class RunnerApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(RunnerApiApplication.class, args);
    }

}
