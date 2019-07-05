
# 网站后台网关:

作用:做微服务的路由转发．

对外只需要提供一个服务端口即可．


    tensquare-base:  # 解释: 路由名称　（随意）
      path: /base/**   # 检测到路径是以 /base/** 开头的路径,都会路由到 tensquare-base 微服务
      serviceId: tensquare-base
     
    假设：
    # 假设请求为:  tensquare-manager/base/label/1   # 使用服务名称,自带端口.
    # 此请求将会被zuul路由到: tensquare-base/label/1
    实例:  http://localhost:9011/base/label/1 转发过程中,将前面部分进行转发处理. 
    等价于: http://localhost:9001/label/1
      


