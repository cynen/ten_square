package com.cynen.client;


import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "tensquare-user")
public interface UserClient {

    // 变更粉丝数
    @RequestMapping(value = "/user/updatefans/{userid}/{x}",method = RequestMethod.POST)
    public Result updateFans(@PathVariable("userid") String userid, @PathVariable("x") int x);


    // 变更关注数
    @RequestMapping(value = "/user/updatefollow/{userid}/{x}",method = RequestMethod.POST)
    public Result updateFollow(@PathVariable("userid") String userid,@PathVariable("x") int x);
}
