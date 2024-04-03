package com.demo.thinkquery.user;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insert(UserDO userDO);
    List<UserDO> findAll();
}
