package com.myth.search.dao;

import com.myth.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Article索引库的DAO
 */
public interface ArticleSearchDao extends ElasticsearchRepository<Article,String> {

    // 分页查询
    // 按照title和content进行模糊匹配.
    public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);

}
