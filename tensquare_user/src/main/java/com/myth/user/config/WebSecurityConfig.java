package com.myth.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 * 通用模板.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // authorizeRequests 所有的security全注解配置实现的开端,表示开始说明需要的权限.
        // 需要的权限分为2部分,第一部分是拦截路径,第二部分是该路径需要的权限
        // antMatchers 表示拦截的路径
        // permitAll表示无需任何权限都可以访问.
        // anyRequest 任何请求  authenticated 认证后才能访问
        // .and().csrf().disable(); 配置crsf 拦截失效.
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
