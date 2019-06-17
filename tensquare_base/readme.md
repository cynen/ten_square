tensquare_base主要是label的服务:

 "{[/label],methods=[POST]}"
 "{[/label/{Id}],methods=[PUT]}"
 "{[/label],methods=[GET]}" 
 "{[/label/{Id}],methods=[DELETE]}"
 "{[/label/{id}],methods=[GET]}" 
 "{[/label/search],methods=[POST]}"
 "{[/label/search/{page}/{size}],methods=[POST]}"


全局异常处理:

 * 标签模板统一异常处理类.
 *
 * @RestControllerAdvice
 * 返回JSON格式的消息.
 * Advice表示是一个通知.



