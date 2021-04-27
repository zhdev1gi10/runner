package com.chenxinhao.runner.core.service;


import com.chenxinhao.runner.core.domain.Example;

public interface ExampleService {

    public Example save(Example example);

    public Example findById(Long id);

}
