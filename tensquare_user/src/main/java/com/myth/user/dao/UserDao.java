package com.myth.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.myth.user.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface UserDao extends JpaRepository<User,String>,JpaSpecificationExecutor<User>{

    public User findUserByMobile(String mobile);

    // 更新粉丝数

    @Modifying
    @Query(value = "update tb_user set fanscount = fanscount + ?2 where id = ?1 ",nativeQuery = true)
    public void updateFans(String userid,int x);


    // 更新关注数
    @Modifying
    @Query(value = "update tb_user set followcount = followcount + ?2 where id = ?1 ",nativeQuery = true)
    public void updateFollow(String userid,int x);


}
