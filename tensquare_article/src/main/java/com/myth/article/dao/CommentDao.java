package com.myth.article.dao;

import com.myth.article.pojo.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 评论的Dao层.
 */
public interface CommentDao extends MongoRepository<Comment,String> {
    /**
     * 根据文章Id查询评论列表
     * @param articleId
     * @return
     */
    public List<Comment> findByArticleid(String articleId);

    /**
     * 分页查询评论列表
     * @param article
     * @param pageable
     * @return
     */
    public Page<Comment> findByArticleid(String article, Pageable pageable);
}
