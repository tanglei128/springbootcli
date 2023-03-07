package com.tyy.springbootcli.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyy.springbootcli.entity.User;
import com.tyy.springbootcli.mapper.UserMapper;
import com.tyy.springbootcli.result.ResponseResult;
import com.tyy.springbootcli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    UserMapper userMapper;

    @Autowired
    UserService userService;


    @Override
    public ResponseResult getUserByMap(Map map) {
        List list = userMapper.selectByMap(map);

        return new ResponseResult().success(list);
    }

    @Override
    public ResponseResult getUserByPage(String id,Long current,Long size) {
        //创建page对象
        Page<User> pageParam = new Page<>(current, size);
        //调用方法实现条件查询分页
        userService.page(pageParam,null);
        List<User> records = pageParam.getRecords();//数据list集合
        long total = pageParam.getTotal();//获取总记录数
        Map map = new HashMap();
        map.put("total",total);
        map.put("records",records);
        return new ResponseResult().success(map);
    }
}
