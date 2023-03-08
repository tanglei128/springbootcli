package com.tyy.springbootcli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyy.springbootcli.common.exception.BusinessException;
import com.tyy.springbootcli.entity.User;
import com.tyy.springbootcli.mapper.UserMapper;
import com.tyy.springbootcli.result.ResponseResult;
import com.tyy.springbootcli.service.UserService;
import com.tyy.springbootcli.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Autowired
    RedisUtil redisUtil;


    @Override
    public ResponseResult getUserByMap(Map map) {
        List list = userMapper.selectByMap(map);
        return  ResponseResult.success();
    }

    @Override
    public ResponseResult getUserByPage(String id,Long current,Long size) {
        //创建page对象
        Page<User> pageParam = new Page<>(current, size);
        //调用方法实现条件查询分页
        Page<User> page = userService.page(pageParam, null);
//        List<User> records = pageParam.getRecords();//数据list集合
//        long total = pageParam.getTotal();//获取总记录数
        return ResponseResult.success(page);
    }

    @Override
    public ResponseResult login(String username, String pwd) {
        User user = new User();
        user.setName(username);
        user.setPwd(pwd);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",username);
        queryWrapper.eq("pwd",pwd);
        User user1 = userMapper.selectOne(queryWrapper);
        if (null!=user1){
            String token = UUID.randomUUID().toString();
            redisUtil.set(token,username,30);
            return ResponseResult.success(token);
        }
        throw new BusinessException("登录失败");
    }
}
