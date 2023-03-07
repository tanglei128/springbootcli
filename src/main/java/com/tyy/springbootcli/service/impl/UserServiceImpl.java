package com.tyy.springbootcli.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyy.springbootcli.entity.User;
import com.tyy.springbootcli.mapper.UserMapper;
import com.tyy.springbootcli.result.ResponseResult;
import com.tyy.springbootcli.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    UserMapper userMapper;


    @Override
    public ResponseResult getUserByMap(Map map) {
        List list = userMapper.selectByMap(map);

        return new ResponseResult().success(list);
    }
}
