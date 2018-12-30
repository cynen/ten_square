package com.myth.article.controller;

import com.myth.article.pojo.Comment;
import com.myth.article.service.CommentService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 查询所有
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true,StatusCode.OK,"查询成功",commentService.findAll());
    }
    /**
     * 新增
     * @param comment
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result addComment(@RequestBody Comment comment){
        commentService.add(comment);
        return new Result(true, StatusCode.OK,"新增成功");
    }


    /**
     * 根据文章id查询评论列表
     */
    @RequestMapping(value = "/article/{articleid}",method = RequestMethod.GET)
    public Result findByArticleId(@PathVariable String articleid){
        List<Comment> list = commentService.findByArticleId(articleid);
        return  new Result(true,StatusCode.OK,"查询成功",list);
    }

    /**
     * 根据文章ID分页查询评论列表.
     */
    @RequestMapping(value = "/article/{articleid}/{page}/{size}",method = RequestMethod.GET)
    public Result findByArticleId(@PathVariable String articleid ,@PathVariable  int page,@PathVariable  int size){
        Page<Comment> pageData = commentService.findByArticleIdPages(articleid,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Comment>(pageData.getTotalElements(),pageData.getContent()));
    }

}
