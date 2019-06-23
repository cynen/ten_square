# 吐槽微服务.

配置文件:
application : 
  data:
    mongodb:
      host: 47.107.177.108
      port: 8380
      database: splitdb
      
      指定的是使用的数据库
      实际使用的Collection是实体类名.
      比如: db.split.find()      


重点是MongoDB的使用:

MongoDB简单使用以及使用场景.

参照自己的Springboot-demo项目中的mongo使用

    // 查询所有的吐槽 
    "{[/split],methods=[GET]}" 
    //根据吐槽id查询对应的吐槽
    "{[/split/{spitId}],methods=[GET]}" 
    // update吐槽信息
    "{[/split/{spitId}],methods=[PUT]}" 
    // 添加吐槽数据
    "{[/split],methods=[POST]}"
    //点赞,控制重复点赞
    "{[/split/thumbup/{spitId}],methods=[PUT]}"
    // 根据上级ID查询吐槽列表.分页查询
    "{[/split/comment/{parentId}/{page}/{size}],methods=[GET]}" 
    // 根据ID删除吐槽
    "{[/split/{spitId}],methods=[DELETE]}"
    //查询吐槽访问量超过指定数值的吐槽,并分页返回 
    "{[/split/query/{visits}/{page}/{size}],methods=[GET]}" 





