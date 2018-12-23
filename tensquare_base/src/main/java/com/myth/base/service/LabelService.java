package com.myth.base.service;

import com.myth.base.dao.LabelDao;
import com.myth.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

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

    public  void deleteById(String labelId){
        labelDao.deleteById(labelId);
    }
}
