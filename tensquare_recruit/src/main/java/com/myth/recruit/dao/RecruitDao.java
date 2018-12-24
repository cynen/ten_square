package com.myth.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.myth.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{


    /**需求分析:查询状态为2并以创建日期降序排序，查询前4条记录
     * 查询指定State,并且按照创建时间,逆序的前4个职位.
     * @param state
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state);

    /**
     * 查询State不为指定值的,按照创建时间逆序排序的前10.
     * @return
     */
    public List<Recruit> findTop10ByStateNotOrderByCreatetimeDesc(String state);
}
