package com.myth.qa.client.impl;

import com.myth.qa.client.BaseClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Component;

@Component
public class BaseClientImpl implements BaseClient {

    @Override
    public Result findById(String id) {
        return new Result(false, StatusCode.REMOTEERROR,"熔断器执行了...");
    }
}
