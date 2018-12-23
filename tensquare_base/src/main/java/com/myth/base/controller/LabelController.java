package com.myth.base.controller;

import com.myth.base.pojo.Label;
import com.myth.base.service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 标签控制层
 */
@RestController
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
     * 删除
     */
    @RequestMapping(value = "/{Id}",method = RequestMethod.DELETE)
    public Result  deleteById(@PathVariable String Id){
        labelService.deleteById(Id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
