package com.myth.recruit.dao;

import com.myth.recruit.pojo.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface EnterpriseDao extends JpaRepository<Enterprise,String>,JpaSpecificationExecutor<Enterprise>{
    // 使用JPA提供的依赖关键字查询.
    /**
     * 根据热门状态获取企业列表
     * @param ishot
     * @return
     */
    public List<Enterprise> findByIshot(String ishot);

    /**
     * 查询热门企业,并且附带标签模糊匹配.
     * @param labels
     * @return
     */
    // public List<Enterprise> findByIshotAndLabelsLike(String labels);
}
