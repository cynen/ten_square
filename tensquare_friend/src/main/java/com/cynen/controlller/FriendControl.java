package com.cynen.controlller;

import com.cynen.service.FriendService;
import com.cynen.service.NoFriendService;
import com.sun.xml.internal.bind.v2.TODO;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/friend")
public class FriendControl {

    @Autowired
    private FriendService friendService;
    @Autowired
    private NoFriendService noFriendService;

    @Autowired
    private HttpServletRequest request;
    /**
     * friendid 是被喜欢的人的id
     * type是类型. 0 不喜欢;1 喜欢
     * @return
     */
    @RequestMapping(value = "/like/{friendid}/{type}",method = RequestMethod.PUT)
    public Result addFriend(@PathVariable String friendid,@PathVariable String type){
        // 1.鉴权
        Claims claims = (Claims) request.getAttribute("claims_user"); // 判断是否有对应的角色.
        if (claims == null) {
            return new Result(false, StatusCode.ACCESSERROR,"权限不足");
        }
        // 2.判断是喜欢还是不喜欢
        if("1".equals(type)){
            // 喜欢
            int result = friendService.addFriend(claims.getId(),friendid);
            if (result == 0){
                return new Result(false,StatusCode.ERROR, "重复添加!");
            }else if(result == 1){
                return new Result(true,StatusCode.OK, "添加成功!");
            }else {
                return new Result(false,StatusCode.ERROR, "添加异常!");
            }
        }else if ("0".equals(type)){
            // 不喜欢
            // TODO  待完成
            // 1. 首先清除friend表中的数据.
            friendService.deletelike(claims.getId(),friendid);

            // 其次,在nofriend表中添加数据
            int result = noFriendService.addNoFriend(claims.getId(),friendid);
            if(result == 0){
                return new Result(false,StatusCode.ERROR,"重复添加NoFriend");
            }else if (result == 1){
                return new Result(true,StatusCode.OK,"添加成功");
            }
            return new Result(false,StatusCode.ERROR,"添加异常");
        }else {
            return new Result(false, StatusCode.ERROR,"type参数异常!");
        }
    }

    @RequestMapping(value = "/{friendid}",method = RequestMethod.DELETE)
    public Result deleteFriend(@PathVariable String friendid){
        // 1.鉴权
        Claims claims = (Claims) request.getAttribute("claims_user"); // 判断是否有对应的角色.
        if (claims == null) {
            return new Result(false, StatusCode.ACCESSERROR,"权限不足");
        }
        // 2. 删除好友
        friendService.deletelike(claims.getId(),friendid);
        return new Result(true,StatusCode.OK,"删除成功");
    }

}
