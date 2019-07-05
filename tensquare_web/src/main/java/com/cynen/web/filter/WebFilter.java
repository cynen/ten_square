package com.cynen.web.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class WebFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true ; // 配置当前过滤器生效
    }

    /**
     * 过滤器中进行请求头的转发,给微服务.
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 具体的业务逻辑
        System.out.println("WebFilter执行了.... ");
        // 向header中添加token
        RequestContext requestContext = RequestContext.getCurrentContext();

        HttpServletRequest request = requestContext.getRequest();
        String authorization = request.getHeader("Authorization"); //自定义的token请求头.
        if (authorization != null){
            requestContext.addZuulRequestHeader("Authorization",authorization); //转发.
        }
        return null;
    }
}
