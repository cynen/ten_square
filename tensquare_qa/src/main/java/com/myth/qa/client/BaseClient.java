package com.myth.qa.client;

import com.myth.qa.client.impl.BaseClientImpl;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * fallback 是指示自己的实现类. 熔断器会调用我们自定义的实现类中的方法.
 * FeignClient 指定模块的 Spring.application.name
 * RequestMapping 需要配置全路径.
 */
@Component
@FeignClient(value = "tensquare-base",fallback = BaseClientImpl.class)
public interface BaseClient {

    @RequestMapping(value = "/label/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id);

}
