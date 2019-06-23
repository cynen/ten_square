# 项目中的参数配置:

1.后期考虑将配置文件中的所有配置统一管理 
做成config配置中心.

2.目前使用的数据库是[自己的阿里云服务器] 

# 注意事项

此项目中,数据交互的方式需要留意. 
目前均是使用json格式数据交互.


# 准备工作

## 数据库
运行数据库,首先直接使用提供的/data/建表语句/db_base.sql 创建对应的数据库和表.

## 开发步骤:

第一步:

tensquare_common [基础服务,被其他服务依赖]

/**
    PageResult 分页查询的结果封装.
    Result  返回结果
    StatusCode 枚举 返回的状态码.
*/

第二步:

所有的微服务包括端口号:

* 基础微服务: 包括标签等.［MySQL ］
tensquare_base : 9001   

* 招聘微服务:［MySQL ］
tensquare_recruit : 9002

* 问答微服务:［MySQL］
tensquare_qa : 9003

* 文章微服务:［MySQL + mongodb + Redis ］
tensquare_article : 9004

* 活动微服务：　［MySQL + Redis］
tensquare_gathering : 9005

* 吐槽微服务: ［mongodb + Redis］
tensquare_split : 9006

* 搜索微服务:[ElasticSearch]
tensquare_search : 9007

* 用户微服务 : RabbitMQ + MySQL  + Redis
tensquare_user : 9008

* 短信服务: RabbitMQ
tensquare_sms : 9009




 
 