package com.myth.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.myth.article.pojo.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{

    /**
     * 文章审核,也就是update语句
     */
    @Modifying
    @Query(value = "UPDATE tb_article t SET t.`state` = '1' WHERE t.`id` = ?",nativeQuery = true)
    public void examine(String articleId);

    /**
     * 文章点赞. update
     */
    @Modifying
    @Query(value = "UPDATE tb_article t SET t.`thumbup` = t.`thumbup`+1 WHERE t.`id` = ?1",nativeQuery = true)
    public int updateThumbup(String id);

}
