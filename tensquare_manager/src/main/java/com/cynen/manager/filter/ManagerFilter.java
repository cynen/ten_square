package com.cynen.manager.filter;


import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;

@Component
public class ManagerFilter extends com.netflix.zuul.ZuulFilter {

    @Autowired
    private JwtUtil jwtUtil; // jwt工具类

    @Override
    public String filterType() {
        return "pre";
        /**
         * pre ：可以在请求被路由之前调用
         * route ：在路由请求时候被调用
         * post ：在route和error过滤器之后被调用
         * error ：处理请求时发生错误时被调用
         */
    }

    /**
     * filterOrder ：通过int值来定义过滤器的执行顺序
     * 在一个模块中有多个filter的时候,此值越小,执行顺序越靠前.
      * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        /**
         * shouldFilter ：返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可
         * 实现过滤器的开关。在此例中, 我们直接返回true，所以该过滤器总是生效
         */
        return true;
    }

    /**
     * run ：过滤器的具体逻辑
     * 因为是管理后台使用，所以需要在过滤器中对token 进行验证。
     * 这里我们通过 ctx.setSendZuulResponse(false) 令zuul过滤该请求，不对其进行路由，
     * 然后通过 ctx.setResponseStatusCode(401) 设置了其返回的错误码
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("经过了 ManagerFilter 的 Zuul 过滤器....");
        // 获取请求头
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        // 通过Zuul网关是2次请求,第一次请求时为了获得对应的微服务,第二次请求才是真实转发.
        if(request.getMethod().equals("OPTIONS")){ // 第一次网关内部的请求
            return null;
        }

        // 1. 判断url,后台管理的需要经过认证才可以访问系统.
        // 但是,当登录的时候,无需认证,所以需要放行登录url
        String url = request.getRequestURL().toString(); //url肯定不可能为空.
        if(url.indexOf("/admin/login") > 0){
            System.out.println("登录URL: " + url);
            return null; // 直接放行.
        }

        // 2. token 不为空, 并且是 Bearer  开头的字符串 [规则是我们自定义]
        String authorization = request.getHeader("Authorization"); //自定义的token请求头.
        if (StringUtils.isNotBlank(authorization) && authorization.startsWith("Bearer ")){
            // 3. 只有当前登录的用户具有admin角色时,才进行转发,其他的都不进行转发. 权限不足
            String token = authorization.substring(7);
            Claims claims = jwtUtil.parseJWT(token); // 解析,需要注意异常
            if(claims != null ){
                if("admin".equals(claims.get("roles"))){
                    // 具备admin角色,才有权限.
                    //带请求头转发
                    requestContext.addZuulRequestHeader("Authorization",authorization);
                    System.out.println("token验证通过, Authorization="+authorization);
                    return null;
                }
            }
        }

        // 3.token为空. 终止转发. 权限不够
        requestContext.setSendZuulResponse(false); // 终止转发.
        requestContext.setResponseStatusCode(401); // 权限不足
        requestContext.setResponseBody("无权访问");
        requestContext.getResponse().setContentType("text/html;charset=utf-8"); //设置响应头的mime类型.
        return null;
    }
}
