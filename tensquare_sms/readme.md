


#　短信微服务

监听RabbitMQ中指定队列的消息,接受到队列中的消息后,进行解析,并发送短信.

目前监听的是手机短信的 队列: 

registry_sms 

消息体的类型: Map<String,String> 

     * 推送到MQ上的消息需要是 Map类型.
     * {
     *     "mobile":"189XXXXXXXX",
     *     "checkcode":"XXXXXX"
     * }


# 注意:

短信微服务是不需要注册到注册中心的. 
此微服务是独立运行的,和整个项目的沟通是通过RabbitMQ进行交互.