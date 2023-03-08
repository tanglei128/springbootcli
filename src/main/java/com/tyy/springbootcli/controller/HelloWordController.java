package com.tyy.springbootcli.controller;

import com.tyy.springbootcli.result.ResponseResult;
import com.tyy.springbootcli.service.UserService;
import com.tyy.springbootcli.utils.ConstantUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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


    @ApiOperation("测试接口1")
    @RequestMapping(value = "/helloworld",method = RequestMethod.GET,produces = ConstantUtil.JSON_PRODUCES)
    public String helloWord(){
        return "hello world";
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
}
