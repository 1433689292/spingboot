package com.example.service;

import com.example.model.Role;
import com.example.model.User;

import java.util.List;

/**
 * Created by yuyong on 2018/11/20.
 */
public interface UserService {
     int addUser(User user);

     int deleteByPrimaryKey(Integer userId);

     int insertSelective(User user);

     int updateByPrimaryKey(User user);

     List<User> selectAllUser(int pageNum,int pageSize);

     List<User>  selByRoleId(User user);

      User  login(User use);
}
