package com.example.mapper;

import com.example.model.Role;
import com.example.model.User;

import java.util.List;


public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);

    List<User> selectAllUser();

    List<User>  selByRoleId(User user);

    User login(User User);
}