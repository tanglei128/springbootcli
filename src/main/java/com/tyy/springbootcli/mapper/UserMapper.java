package com.tyy.springbootcli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyy.springbootcli.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
