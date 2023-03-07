package com.tyy.springbootcli.controller;

import com.tyy.springbootcli.result.ResponseResult;
import com.tyy.springbootcli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class HelloWordController {

    @Autowired
    UserService userService;


    @RequestMapping("/helloworld")
    public String helloWord(){
        return "hello world";
    }


    @RequestMapping("/query/users")
    public ResponseResult queryUsers(String id){
        Map map = new HashMap<>();
        map.put("id",id);
        ResponseResult userByMap = userService.getUserByMap(map);
        return userByMap;
    }

    @RequestMapping("/query/users/pages")
    public ResponseResult queryUsers(String id,Long current,Long size){

        ResponseResult userByMap = userService.getUserByPage(id,current,size);
        return userByMap;
    }
}
