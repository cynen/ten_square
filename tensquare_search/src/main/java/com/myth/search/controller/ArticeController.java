package com.myth.search.controller;

import com.myth.search.pojo.Article;
import com.myth.search.service.ArticleSearchService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/article")
public class ArticeController {
    @Autowired
    private ArticleSearchService articleSearchService;



    // 新增数据
    @RequestMapping(method = RequestMethod.POST)
    public Result addArticle(@RequestBody Article article){
        articleSearchService.add(article);
        return new Result(true, StatusCode.OK,"新增成功");
    }


    // 查询数据
    @RequestMapping(value = "/search/{keywords}/{page}/{size}",method = RequestMethod.GET)
    public Result findByTitleOrContentLike(@PathVariable String keywords,@PathVariable int page,@PathVariable int size){
        Page<Article> pageData = articleSearchService.findByTitleOrContentLike(keywords,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Article>(pageData.getTotalElements(),pageData.getContent()));
    }


}
