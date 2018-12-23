package com.myth.base.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 标签模板统一异常处理类.
 *
 * @RestControllerAdvice
 * 返回JSON格式的消息.
 * Advice表示是一个通知.
 *
 * @RestController 不需要添加@ResponseBody.
 *
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result error(Exception e){
        e.printStackTrace();
        return  new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
