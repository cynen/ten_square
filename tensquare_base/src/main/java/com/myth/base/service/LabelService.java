package com.myth.base.service;

import com.myth.base.dao.LabelDao;
import com.myth.base.pojo.Label;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部标签
     */
    public List<Label> findAll(){
        return labelDao.findAll();
    }


    public Label findById(String labelId){
        return  labelDao.findById(labelId).get();
    }

    public void  add(Label label){
        // 需要设置一个主键.
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }

    public void update(Label label){
        // 如果label中自带主键,就会直接update
        labelDao.save(label);
    }

    /**
     * 根据ID删除对应的Label.
     * @param labelId
     */
    public  void deleteById(String labelId){
        labelDao.deleteById(labelId);
    }
    /**
     * SpringData-jpa的标准用法.
     * 条件查询.
     */
    public List<Label> findSearch(Label label) {
        return  labelDao.findAll(createSpecification(label));
    }

    /**
     * 带条件的分页查询.
     */
    public Page<Label> pageQuery(Label label, int page, int size) {
        //1. 构造一个查询条件.
        Specification specification = createSpecification(label);
        PageRequest pageRequest = PageRequest.of(page - 1,size);
        //2.查询结果
        // 3.返回结果.
        return  labelDao.findAll(specification,pageRequest);
    }

    // 构造一个查询条件对象
    private Specification createSpecification(Label label) {
        return  new Specification() {
            /**
             * @param root            根对象,也就是要吧条件封装到哪个对象中. where 类名= label.getid;
             * @param criteriaQuery   封装的都是查询的关键字,比如group by,order by
             * @param criteriaBuilder 用来封装条件对象的,如果直接返回null,表示不需要任何条件.
             * @return
             */
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                // 存放所有的查询条件.
                List<Predicate> list = new ArrayList<>();
                // 按照标签名称查询
                if (StringUtils.isNotBlank(label.getLabelname())) {
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }
                // 按照标签的State状态查询.
                if (StringUtils.isNotBlank(label.getState())) {
                    Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }
                // 可以添加多个条件.
                if(StringUtils.isNotBlank(label.getRecommend())){
                    Predicate predicate = criteriaBuilder.equal(root.get("recommend").as(String.class), label.getRecommend());
                    list.add(predicate);
                }
                Predicate[] parr = new Predicate[list.size()];
                list.toArray(parr);
                // return criteriaBuilder.and(parr);
                return  criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };
    }


}
