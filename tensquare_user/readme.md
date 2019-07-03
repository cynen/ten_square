# 密码加密
* BCrypt密码加密
对数据库中用户的密码进行加密.


# JWT相关知识点
1. JWT的基本知识
2. JWTUtils的工具类的功能. 
3. 拦截器Interceptor的使用
4. 权限验证.
用户登录后,返回token/



## token生成规则:

管理员登陆后台签发token

前后端约定：前端请求微服务时需要添加头信息Authorization ,内容为Bearer+空格+token


初步实现的功能:
1. 添加admin用户时,对admin用户的密码进行加密存储.
2. admin用户登录的时候,进行Security登录验证.
3. admin用户登录成功后,生成jwt的token令牌 [在adminController中实现]
4. admin用户删除普通用户的需要鉴权[在userController中实现]
5. 使用拦截器实现拦截鉴权 [配置拦截器需要配套的配置Configuration]



扩展: 
如果希望实现用户的新增密码加密,就需要配套考虑用户的登录的认证.


注意点: 
当 Dao层使用的是Query语句,并且是 Update/Delete 语句的时候, JPA强制要求添加Trasactional 注解.

