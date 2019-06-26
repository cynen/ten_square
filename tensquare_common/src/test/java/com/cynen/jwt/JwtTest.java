package com.cynen.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtTest {

    // 生成 jwt
    public static void main(String[] args) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("123") // 用户id
                .setSubject("测试用户")
                .setIssuedAt(new Date()) // 指定生成时间
                .claim("test","自定义值")
                // .setExpiration(new Date(new Date().getTime() + 60000)) // 过期时间
                .signWith(SignatureAlgorithm.HS256, "salty"); // 签证
        // 生成token
        System.out.println(jwtBuilder.compact());

    }
}
