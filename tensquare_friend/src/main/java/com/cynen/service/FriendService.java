package com.cynen.service;


import com.cynen.dao.FriendDao;
import com.cynen.pojo.Friend;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FriendService {

    @Autowired
    private FriendDao friendDao;


    @Transactional
    public int addFriend(String userid,String friendid){
        ////判断如果用户已经添加了这个好友，则不进行任何操作,返回0
        int count =  friendDao.queryUserFocus(userid,friendid);
        if (count > 0 ){
            return  0; // 已经添加了好友
        }
        // 2. 向喜欢表中添加数据
        Friend friend = new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        friend.setIslike("0");
        friendDao.save(friend);

        // 3. 判断喜欢的人是否喜欢自己.
        // 如果喜欢的人也喜欢自己,就将2比数据添加为1.
        count = friendDao.queryUserFocus(friendid,userid);
        if (count > 0 ){
            friendDao.updateLike(userid,friendid,"1");
            friendDao.updateLike(friendid,userid,"1");
        }
        return  1; // 1表示执行成功.
    }





}
