package com.myth.base;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * 当前Module的入口
 */
@SpringBootApplication
@EnableEurekaClient
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
    }

    // 注入到Spring容器中.为了在整个tensquare_base容器中使用这个bean.
    @Bean
    public IdWorker idWorker(){
        return  new IdWorker();
    }
}
