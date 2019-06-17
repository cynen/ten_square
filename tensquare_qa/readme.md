 
#  特点:

演示数据库直接在Dao层的Repository编写SQL语句.
 
 
 问答微服务:
 
 "{[/problem],methods=[POST]}" 
 "{[/problem/{id}],methods=[PUT]}" 
 "{[/problem/{id}],methods=[DELETE]}"
 "{[/problem],methods=[GET]}" 
 "{[/problem/{id}],methods=[GET]}" 
 "{[/problem/search],methods=[POST]}"
 "{[/problem/search/{page}/{size}],methods=[POST]}" 
 "{[/problem/hotlist/{label}/{page}/{size}],methods=[GET]}"
 "{[/problem/newlist/{label}/{page}/{size}],methods=[GET]}" 
 "{[/problem/waitlist/{label}/{page}/{size}],methods=[GET]}" 

 "{[/reply],methods=[POST]}" 
 "{[/reply/{id}],methods=[PUT]}" 
 "{[/reply/{id}],methods=[DELETE]}" 
 "{[/reply],methods=[GET]}" 
 "{[/reply/{id}],methods=[GET]}" 
 "{[/reply/search],methods=[POST]}" 
 "{[/reply/search/{page}/{size}],methods=[POST]}" 
 
 异常处理: 
 
 "{[/error]}" 
 "{[/error],produces=[text/html]}" 