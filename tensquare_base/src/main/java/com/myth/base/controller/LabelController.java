package com.myth.base.controller;

import com.myth.base.pojo.Label;
import com.myth.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签控制层
 */
@RestController
@CrossOrigin   // 跨域必须添加的注解.
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

    /**
     * 查询全部列表.
     * 默认匹配的URL
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true,StatusCode.OK,"查询成功",labelService.findAll());
    }

    /**
     * 根据Id查询.
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id){
        // int i = 1/0; 异常的话,就会返回 ExceptionHandler中处理的结果.
        return new Result(true, StatusCode.OK,"查询成功",labelService.findById(id));
    }

    /**
     * 新增
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Label label){
        labelService.add(label);
        return new Result(true,StatusCode.OK,"新增成功");
    }
    /**
     * 更新
     *
     */
    @RequestMapping(value = "/{Id}",method = RequestMethod.PUT)
    public  Result update(@RequestBody Label label,@PathVariable String Id){
        // label.setId(Id);
        labelService.update(label);
        return  new Result(true,StatusCode.OK,"更新成功");
    }

    /**
     * 根据ID进行删除
     */
    @RequestMapping(value = "/{Id}",method = RequestMethod.DELETE)
    public Result  deleteById(@PathVariable String Id){
        labelService.deleteById(Id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /**
     * 条件查询.
     * 文档没有要求分页.
     */
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label){
        // labelService.findSearch();
        List<Label> list = labelService.findSearch(label);
        return  new Result(true,StatusCode.OK,"查询成功",list);
    }
    /**
     * 带条件的分页查询.
     *
     */
    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result findSearchPages(@RequestBody Label label,@PathVariable int page,@PathVariable int size){
        // labelService.findSearch();
        Page<Label> pageData = labelService.pageQuery(label,page,size);
        return  new Result(true,StatusCode.OK,"查询成功",new PageResult<Label>(pageData.getTotalElements(),pageData.getContent()));
    }

}
