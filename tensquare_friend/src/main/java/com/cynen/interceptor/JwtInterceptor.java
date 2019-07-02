package com.cynen.interceptor;


import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    // 做一个preInterceptor ,做前置拦截.
    // 主要目的: 解析token
    // 只是做一个登录的认证,以及角色的判断.并不会进行具体的拦截.
    // 无论如何,最终都会泛型.
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("经过了拦截器");
        // 从请求头中获取信息.
        String authHeader = request.getHeader("Authorization");
        // 如果header中包含 " Authorization" 字段,就需要进一步判断.
        if(StringUtils.isNotBlank(authHeader) && authHeader.startsWith("Bearer ")){
            String token = authHeader.substring(7);
            try {
                //防止令牌过期.
                Claims claims = jwtUtil.parseJWT(token);
                if (claims != null) {
                    // 当验证用户带token后,根据权限不同,向request中存储对应的key值.
                    if ("admin".equals(claims.get("roles"))){
                        request.setAttribute("claims_admin",claims);
                    }
                    if ("user".equals(claims.get("roles"))){
                        request.setAttribute("claims_user",claims);
                    }
                }
            }catch (Exception e){
                throw new RuntimeException("[请重新登录],令牌已失效!");
            }
        }

        return true;
    }
}
