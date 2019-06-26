package com.cynen.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

public class JwtParse {

    public static void main(String[] args) {
        // 解析JWT令牌
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMjMiLCJzdWIiOiLmtYvor5XnlKjmiLciLCJpYXQiOjE1NjE1NjA3MDUsInRlc3QiOiLoh6rlrprkuYnlgLwifQ.FmErxD7xaKBWLkntZbzW-jXOltOgiwxvtRLwPUPvVO4";
        try {
            // claims实际就是一个map
            // 首先必须提供自定义的 secret
            // 指定解析的token
            Claims claims = Jwts.parser().setSigningKey("salty").parseClaimsJws(token).getBody();


            System.out.println("登录用户ID: "+claims.getId());
            System.out.println("登录用户名称: "+claims.getSubject());
            System.out.println("登录时间: "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
            System.out.println("自定义参数: "+claims.get("test"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}
