package com.chenxinhao.runner.api.controller;

import com.chenxinhao.runner.api.utils.ResultGenerator;
import com.chenxinhao.runner.api.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/example")
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @PostMapping("/save")
    public Result save(@RequestParam String title,
                       @RequestParam String remark) {
        Example example = new Example();
        example.setTitle(title);
        example.setRemark(remark);

        Example result = exampleService.save(example);
        return ResultGenerator.ok(result);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Long id){
       Example example = exampleService.findById(id);
       return  ResultGenerator.ok(example);
    }
}
