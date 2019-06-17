
招聘微服务,需要实现 企业和 职位.


 "{[/enterprise],methods=[POST]}" onto pu
 "{[/enterprise/{id}],methods=[PUT]}" ont
 "{[/enterprise/{id}],methods=[DELETE]}"
 "{[/enterprise/{id}],methods=[GET]}" ont
 "{[/enterprise],methods=[GET]}" onto pub
 "{[/enterprise/search],methods=[POST]}" 
 "{[/enterprise/search/{page}/{size}],methods=[POST]}"
 "{[/enterprise/search/hotlist],methods=[GET]}"
 "{[/recruit],methods=[POST]}" 
 "{[/recruit/{id}],methods=[PUT]}" 
 "{[/recruit/{id}],methods=[DELETE]}" 
 "{[/recruit/{id}],methods=[GET]}" 
 "{[/recruit],methods=[GET]}"
 "{[/recruit/search/newlist],methods=[GET]}"
 "{[/recruit/search/recommend],methods=[GET]}" 
 "{[/recruit/search],methods=[POST]}" 
 "{[/recruit/search/{page}/{size}],methods=[POST]}" 

统一异常处理: 
 "{[/error]}" 
 "{[/error],produces=[text/html]}" 
