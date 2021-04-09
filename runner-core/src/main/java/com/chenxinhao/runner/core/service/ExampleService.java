package com.chenxinhao.runner.core.service;

import com.chenxinhao.runner.core.domain.Example;

public interface ExampleService {
    //新增示例
    public Example save(Example example);

    //通过ID查询示例信息
    public Example findById(Long id);
}
