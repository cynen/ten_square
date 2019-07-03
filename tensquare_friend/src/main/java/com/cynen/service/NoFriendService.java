package com.cynen.service;

import com.cynen.dao.NoFriendDao;
import com.cynen.pojo.Friend;
import com.cynen.pojo.NoFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class NoFriendService {

    @Autowired
    private NoFriendDao noFriendDao;


    @Transactional
    public int addNoFriend(String userid, String friendid) {
        ////判断如果用户已经添加了这个非好友，则不进行任何操作,返回0
        NoFriend friend =  noFriendDao.findByUseridAndFriendid(userid,friendid);
        if (friend != null  ){
            return  0; // 已经添加了非好友
        }
        // 2. 向不喜欢表中添加数据
        friend = new NoFriend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        noFriendDao.save(friend);

        return  1; // 1表示执行成功.
    }
}
