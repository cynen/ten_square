package com.myth.split.controller;

import com.myth.split.pojo.Split;
import com.myth.split.service.SplitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/split")
public class SplitController {

    @Autowired
    private SplitService splitService;

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 查询所有的吐槽.
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
//        splitService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",splitService.findAll());

    }

    /**
     * 根据id查询吐槽信息
     * @param spitId
     * @return
     */
    @RequestMapping(value ="/{spitId}" ,method = RequestMethod.GET)
    public Result findById(@PathVariable String spitId){
        return new Result(true,StatusCode.OK,"查询成功",splitService.findById(spitId));
    }

    /**
     * 新增
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result addSplit(@RequestBody Split split){
        splitService.add(split);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /**
     * 根据id进行修改
     * 注意,如果没有设置ID,就会变成新增数据了.
     */
    @RequestMapping(value = "/{spitId}",method = RequestMethod.PUT)
    public Result modfiSplit(@RequestBody Split split,@PathVariable String spitId){
        // splitService.add(split);
        split.set_id(spitId); // 将接收到的id存放到Split对象中去.
        splitService.update(split);// 更新
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/{spitId}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String spitId){
        splitService.deleteById(spitId);
        return  new Result(true,StatusCode.OK,"删除成功");
    }

    /**
     * 点赞,控制重复点赞
     */
    @RequestMapping(value = "/thumbup/{spitId}",method = RequestMethod.PUT)
    public Result thunmpb(@PathVariable String spitId){
        // 先获取用户.
        String userid = "123456"; // 目前没有做,先写死.
        if (redisTemplate.opsForValue().get("thumbup:"+userid+":"+spitId)!= null){
            // 说明查到过,已经点赞了.
            return new Result(true,StatusCode.REPERROR,"你已经点赞过了");
        }
        splitService.thunmpbById(spitId);
        redisTemplate.opsForValue().set( "thumbup:"+userid+":"+spitId , "1"); // 点赞成功后,设置对应的key-value值.
        return new Result(true,StatusCode.OK,"点赞成功");
    }

    /**
     * 查询吐槽访问量超过指定数值的吐槽,并分页返回
     * 自定义的API
     */
    @RequestMapping(value = "/query/{visits}/{page}/{size}",method = RequestMethod.GET)
    public Result findPagesCondition(@PathVariable int visits,@PathVariable int page,@PathVariable int size){
        Page<Split> pageData = splitService.findPagesCondition(visits,page,size);
        return  new Result(true,StatusCode.OK,"查询成功",new PageResult<Split>(pageData.getTotalElements(),pageData.getContent()));
    }

    /**
     * 根据上级ID查询吐槽列表.分页查询
     * @param parentId
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/comment/{parentId}/{page}/{size}",method = RequestMethod.GET)
    public Result findByParentId(@PathVariable String parentId,@PathVariable int page,@PathVariable int size){
        Page<Split> pageData = splitService.findByParentid(parentId,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Split>(pageData.getTotalElements(),pageData.getContent()));
    }

}
