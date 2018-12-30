package com.myth.split.dao;

import com.myth.split.pojo.Split;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 吐槽数据访问层.
 */
public interface SplitDao extends MongoRepository<Split,String> {

    // 带条件的分页查询.
    public Page<Split> findSplitByVisitsIsGreaterThanEqual(Integer visits, Pageable pageable);

    /**
     * 根据父节点,查询吐槽列表,分页
     * @param parentid
     * @param pageable
     * @return
     */
    public  Page<Split> findByParentid(String parentid,Pageable pageable);
}
