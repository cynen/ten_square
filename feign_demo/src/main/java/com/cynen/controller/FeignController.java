package com.cynen.controller;


import com.cynen.client.BaseClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 标签控制层
 */
@RestController
@CrossOrigin   // 跨域必须添加的注解.
@RequestMapping("/feigndemo")
public class FeignController {


    @Autowired
    private BaseClient baseClient;


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id){

        return baseClient.findById(id);
    }

}
