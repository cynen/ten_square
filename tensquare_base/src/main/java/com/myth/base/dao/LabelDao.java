package com.myth.base.dao;

import com.myth.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * JpaRepository提供了基本的增删改查
 * JpaSpecificationExecutor用于做复杂的条件查询
 */
public interface LabelDao extends JpaRepository<Label,String>,JpaSpecificationExecutor<Label>{

}
