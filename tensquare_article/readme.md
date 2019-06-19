
# 特点

此微服务依赖于Redis/MongoDB

Redis的使用.

stringRedisTemplate.opsForValue().set("test", "100",60*10,TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间
stringRedisTemplate.opsForValue().get("test")//根据key获取缓存中的val
stringRedisTemplate.boundValueOps("test").increment(-1);//val做-1操作
stringRedisTemplate.boundValueOps("test").increment(1);//val +1
stringRedisTemplate.getExpire("test")//根据key获取过期时间
stringRedisTemplate.getExpire("test",TimeUnit.SECONDS)//根据key获取过期时间并换算成指定单位
stringRedisTemplate.delete("test");//根据key删除缓存
stringRedisTemplate.hasKey("546545");//检查key是否存在，返回boolean值
stringRedisTemplate.expire("red_123",1000 , TimeUnit.MILLISECONDS);//设置过期时间
stringRedisTemplate.opsForSet().add("red_123", "1","2","3");//向指定key中存放set集合
stringRedisTemplate.opsForSet().isMember("red_123", "1")//根据key查看集合中是否存在指定数据
stringRedisTemplate.opsForSet().members("red_123");//根据key获取set集合



 "{[/article],methods=[POST]}" 
 "{[/article/{id}],methods=[PUT]}" 
 "{[/article/{id}],methods=[DELETE]}" 
 "{[/article],methods=[GET]}" 
 "{[/article/{id}],methods=[GET]}" 
 "{[/article/examine/{articleId}],methods=[PUT]}" 
 "{[/article/thumbup/{articleId}],methods=[PUT]}" 
 "{[/article/search/{page}/{size}],methods=[POST]}" 
 "{[/article/search],methods=[POST]}"
 "{[/channel],methods=[POST]}" 
 "{[/channel/{id}],methods=[PUT]}" 
 "{[/channel/{id}],methods=[DELETE]}" 
 "{[/channel],methods=[GET]}" 
 "{[/channel/{id}],methods=[GET]}" 
 "{[/channel/search],methods=[POST]}" 
 "{[/channel/search/{page}/{size}],methods=[POST]}" 
 "{[/column],methods=[POST]}"
 "{[/column/{id}],methods=[PUT]}" 
 "{[/column/{id}],methods=[DELETE]}" 
 "{[/column],methods=[GET]}" 
 "{[/column/{id}],methods=[GET]}" 
 "{[/column/search],methods=[POST]}" 
 "{[/column/search/{page}/{size}],methods=[POST]}" 
 "{[/comment],methods=[GET]}" 
 "{[/comment],methods=[POST]}" 
 "{[/comment/article/{articleid}],methods=[GET]}" 
 "{[/comment/article/{articleid}/{page}/{size}],methods=[GET]}" 
 
 异常处理:
 
 "{[/error]}" 
 "{[/error],produces=[text/html]}" 

