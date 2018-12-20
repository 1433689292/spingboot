package com.example.service.serviceImpl;

import com.example.mapper.UserMapper;
import com.example.model.Role;
import com.example.model.User;
import com.example.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yuyong on 2018/11/20.
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper  userMapper;

    public int addUser(User user) {
        return userMapper.insert(user);
    }


    public List<User> selectAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return  userMapper.selectAllUser();
    }


    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKey(user);
    }


    public int insertSelective(User user) {
        return  userMapper.insertSelective(user);
    }


    public int deleteByPrimaryKey(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }


    public List<User> selByRoleId(User user) {
        return  userMapper.selByRoleId(user);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}

