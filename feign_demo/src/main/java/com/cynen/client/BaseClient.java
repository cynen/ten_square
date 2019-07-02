package com.cynen.client;


// 准备调用base中的label

import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component  // 只是为了不报错.
@FeignClient(value = "tensquare-base")  // 使用注解@FeignClient 定义feign客户端 ;
public interface BaseClient {

    @RequestMapping(value = "/label/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id);
}
