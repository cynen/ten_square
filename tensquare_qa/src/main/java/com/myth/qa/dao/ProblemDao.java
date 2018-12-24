package com.myth.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.myth.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

    /**
     * 根据标签查询最新的回答.
     * 并且分页.
     * @param labelid
     * @param pageable
     * @return
     */
   // @Query(value = "SELECT * FROM tb_problem p,tb_pl pl WHERE p.`id` = pl.`labelid` AND pl.`labelid` = ? ORDER BY p.`replytime` DESC\n",nativeQuery = true)
    // public Page<Problem> findnewlistBylabelId(String labelid, Pageable pageable);
    @Query(value = "select * from tb_problem p,tb_pl pl where p.`id` = pl.`problemid` and pl.`labelid` = ?1 order by p.`replytime` desc",nativeQuery = true)
    public Page<Problem> findnewlistBylabelId(String labelid,Pageable pageable);

    /**
     * 最热门回答.
     * @return
     */
    @Query(value = "SELECT * FROM tb_problem p,tb_pl pl WHERE p.`id` = pl.`problemid` AND pl.`labelid` = ?1 ORDER BY p.`reply` DESC",nativeQuery = true)
    public  Page<Problem> hotlist(String labelid,Pageable pageable);

    /**
     * 等待回答.
     * @return
     */
    @Query(value = "\n" +
            "SELECT * FROM tb_problem p,tb_pl pl WHERE p.`id` = pl.`problemid` AND pl.`labelid` = ?1 AND p.`reply` = 0 ORDER BY p.`createtime` DESC",nativeQuery = true)
    public Page<Problem> waitlist(String labelid,Pageable pageable);
}
