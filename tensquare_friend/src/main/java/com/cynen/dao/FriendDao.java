package com.cynen.dao;

import com.cynen.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendDao extends JpaRepository<Friend,String> {

    /**
     * 通过userid去查询当前
     * @param userid
     * @param friendid
     * @return
     */
    @Query(value = "SELECT count(1) FROM tb_friend where userid = ?1 and friendid = ?2",nativeQuery = true)
    public int queryUserFocus(String userid,String friendid);

    /**
     * 更新为互为喜欢
     */
    @Modifying
    @Query(value = "UPDATE tb_friend set islike = ?3 where userid = ?1 and friendid = ?2 ",nativeQuery = true)
    public int updateLike(String userid,String friendid,String islike);


    @Modifying
    @Query(value = "delete from tb_friend where userid = ?1 and friendid = ?2 ",nativeQuery = true)
    public int deleteByUseridAndFriendid(String userid,String friendid);
}
