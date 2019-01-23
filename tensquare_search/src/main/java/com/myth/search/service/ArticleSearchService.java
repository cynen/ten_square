package com.myth.search.service;

import com.myth.search.dao.ArticleSearchDao;
import com.myth.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import util.IdWorker;

@Service
public class ArticleSearchService {

    @Autowired
    private ArticleSearchDao articleSearchDao;

    @Autowired
    private IdWorker idWorker;
    /**
     * 索引新增一笔数据
     */
    public void add(Article article){
        article.setId(idWorker.nextId()+"");
        articleSearchDao.save(article);
    }

    /**
     * title和content进行模糊匹配
     */
    public Page<Article> findByTitleOrContentLike(String keywords,int page,int size){
        Pageable pageable = PageRequest.of(page-1,size);
        return articleSearchDao.findByTitleOrContentLike(keywords,keywords,pageable);
    }


}
