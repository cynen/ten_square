package com.myth.article.service;

import com.myth.article.dao.CommentDao;
import com.myth.article.pojo.Comment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private IdWorker idWorker;


    /**
     * 新增一笔评论
     * @param comment
     */
    public void add(Comment comment) {
        comment.set_id(idWorker.nextId()+"");
        if (StringUtils.isBlank(comment.getParentid())){
            comment.setParentid("0"); // 如果没有指定parent,就说明当前评论是一级.
        }
        commentDao.save(comment);
    }

    public List<Comment> findAll(){
        return commentDao.findAll();
    }
    /**
     * 分页查询
     */
    public List<Comment> findByArticleId(String articleId){
        return commentDao.findByArticleid(articleId);
    }
    /**
     * 查询全部列表
     */
    public Page<Comment> findByArticleIdPages(String articleId,int page,int size){
        // 构建分页参数
        Pageable pageable = PageRequest.of(page -1,size);
        return commentDao.findByArticleid(articleId,pageable);
    }

}
