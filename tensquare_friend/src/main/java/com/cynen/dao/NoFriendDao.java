package com.cynen.dao;

import com.cynen.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoFriendDao extends JpaRepository<NoFriend,String> {

    public NoFriend findByUseridAndFriendid(String userid,String friendid);


}
