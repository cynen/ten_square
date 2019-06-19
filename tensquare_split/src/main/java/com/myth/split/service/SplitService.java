package com.myth.split.service;

import com.myth.split.dao.SplitDao;
import com.myth.split.pojo.Split;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.Date;
import java.util.List;

@Service
public class SplitService {

    @Autowired
    private SplitDao splitDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;//原生操作Mongodb的对象.
    /**
     * 全部查询,不带任何条件
     * @return
     */
    public List<Split> findAll(){
        return  splitDao.findAll();
    }

    /**
     * 根据Split的ID进行查询.
     * @param id
     * @return
     */
    public Split findById(String id){
        return splitDao.findById(id).get();
    }

    /**
     * 新增一笔 Split 数据
     * @param split
     */
    public void add(Split split){
        split.set_id(idWorker.nextId()+""); // 设置主键
        // 做点数据
        split.setPublishtime(new Date()); // 发布日期
        split.setShare(0); // 状态
        split.setThumbup(0); // 点赞数
        split.setVisits(0); // 访问量
        split.setComment(0); // 回复数
        split.setState("1"); // 状态 初始发布
        // 判断当前吐槽是否有父节点.
        if(StringUtils.isNotBlank(split.getParentid())){
            // 有父节点的时候,需要对其父节点的回复数 + 1
            Query query = new Query(); // 构建一个查询条件
            query.addCriteria(Criteria.where("_id").is(split.getParentid()));
            Update update = new Update();// 构建一个更新条件对象
            update.inc("comment",1);
            mongoTemplate.updateFirst(query,update,"split");
        }
        splitDao.save(split);
    }

    /**
     * 更新数据
     * @param split
     */
    public void  update(Split split){
        splitDao.save(split);
    }

    /**
     * 根据ID进行删除
     * @param id
     */
    public void  deleteById(String id){
        splitDao.deleteById(id);
    }

    /**
     * 点赞
     * 需要判断 spitId 是否有parentid,如果有Parentid,就需要对parent的Split的点赞数+1
     * 否则对自己的点赞数加+1
     * @param spitId
     */
    public void thunmpbById(String spitId) {
        // 获得被点赞的Split
        /*Split split = splitDao.findById(spitId).get();
        split.setThumbup(split.getThumbup() +1);
        splitDao.save(split);*/

        // 获得被点赞数.原生Java实现.
        // 效率比上面一个稍微高一点.  原生update:  cdb.spit.update({"_id":"2"},{$inc:{"visit":Numberint(1)}})
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(spitId));
        Update update = new Update();
        update.inc("thumbup",1);
        mongoTemplate.updateFirst(query,update,"split");
    }

    /**
     * 根据访问量进行查询,分页查询
     * @param visits
     * @param page
     * @param size
     * @return
     */
    public Page<Split> findPagesCondition(Integer visits,int page,int size){
        Pageable pageable = PageRequest.of(page -1,size);
       return splitDao.findSplitByVisitsIsGreaterThanEqual(visits,pageable);
    }

    /**
     * 根据上级ID,查询吐槽列表,分页展示.
     * @param parentid
     * @param page
     * @param size
     * @return
     */
    public Page<Split> findByParentid(String parentid,int page,int size){
        // 构建分页
        Pageable pageable = PageRequest.of(page-1,size);
        return splitDao.findByParentid(parentid,pageable);
    }

}
