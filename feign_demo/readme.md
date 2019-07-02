
Feign 的使用注意事项: 

谁调用,谁就需要修改. 

被调用的可以不用动.

需要依赖被调用的模块.


配置点: 
* 1.添加Eureka客户端的依赖.
* 2.添加Feign客户端的依赖.
* 3.application.properties 中添加Eureka的注册中心的额地址.
* 4.主类上添加3个关键注解: 

        @SpringBootApplication 
        @EnableEurekaClient // eureka客户端
        @EnableDiscoveryClient 
        @EnableFeignClients  // 使用注解@EnableFeignClients启用feign客户端
        public class FeignDemo {...}

从Spring Cloud Edgware开始，@EnableDiscoveryClient 或@EnableEurekaClient 可省略。只需加上相关依赖，并进行相应配置，即可将微服务注册到服务发现组件上。
        
@EnableDiscoveryClient和@EnableEurekaClient共同点就是：都是能够让注册中心能够发现，扫描到该服务。
        
不同点：@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心。


