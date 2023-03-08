package com.tyy.springbootcli.controller;

import com.tyy.springbootcli.common.exception.BusinessException;
import com.tyy.springbootcli.result.ResponseResult;
import com.tyy.springbootcli.service.UserService;
import com.tyy.springbootcli.utils.ConstantUtil;
import com.tyy.springbootcli.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BulkBeanException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Api(tags = "接口类")
@RestController
@RequestMapping("/v1")
public class HelloWordController {

    @Autowired
    UserService userService;

    @Autowired
    RedisUtil redisUtil;


    @ApiOperation("测试接口1")
    @RequestMapping(value = "/helloworld",method = RequestMethod.GET,produces = ConstantUtil.JSON_PRODUCES)
    public String helloWord(){
        return "hello world";
    }

    @ApiOperation("自定义异常处理接口测试")
    @RequestMapping(value = "/exception",method = RequestMethod.GET,produces = ConstantUtil.JSON_PRODUCES)
    public ResponseResult exception(){
        throw new BusinessException("自定义抛出异常-由全局异常处理");
    }

    @RequestMapping(value="/query/users",method = RequestMethod.GET,produces = ConstantUtil.JSON_PRODUCES)
    public ResponseResult queryUsers(String id){
        Map map = new HashMap<>();
        map.put("id",id);
        ResponseResult userByMap = userService.getUserByMap(map);
        return userByMap;
    }

    @ApiOperation("分页查询")
    @RequestMapping(value = "/query/users/pages",method = RequestMethod.GET,produces = ConstantUtil.JSON_PRODUCES)
    public ResponseResult queryUsers(String id,Long current,Long size){

        ResponseResult userByMap = userService.getUserByPage(id,current,size);
        return userByMap;
    }

    @ApiOperation("redis测试接口-存放值")
    @RequestMapping(value = "/redis/set",method = RequestMethod.GET,produces = ConstantUtil.JSON_PRODUCES)
    public ResponseResult redisSet(String id){
        redisUtil.set(id,id);
        Object o = redisUtil.get(id);
        return ResponseResult.success(o);
    }
}
