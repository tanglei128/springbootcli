package com.tyy.springbootcli.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyy.springbootcli.entity.User;
import com.tyy.springbootcli.result.ResponseResult;

import java.util.List;
import java.util.Map;

public interface UserService extends IService<User> {

    ResponseResult getUserByMap(Map map);

}
