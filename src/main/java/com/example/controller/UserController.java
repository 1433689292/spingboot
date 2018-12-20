package com.example.controller;


import com.example.model.User;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yuyong on 2018/11/21.
 */

@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserService userService;

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/addUser")
    public  int addUser(User user){
         return userService.addUser(user);
     }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
     @ResponseBody
     @RequestMapping("/delUser")
     public  int delUser(Integer id){
        return userService.deleteByPrimaryKey(id);
     }

    /**
     * 添加用户信息（根据给的条件）
     * @param user
     * @return
     */
     @ResponseBody
     @RequestMapping("/insert")
     public int insertSelective(User user){
        return  userService.insertSelective(user);
     }

    /**
     *根据用户的更改信息
     * @param user
     * @return
     */
     @ResponseBody
     @RequestMapping("/update")
     public  int updateById(User user){
        return  userService.updateByPrimaryKey(user);
     }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
     @ResponseBody
     @RequestMapping("/all/{pageNum}/{pageSize}")
     public Object selectAllUser(@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize){
         return userService.selectAllUser(pageNum,pageSize);
     }

    /**
     * 根据用户的名字查用户的角色
     * @param user
     * @return
     */
     @ResponseBody
     @RequestMapping("/selRole")
     public List<User> selectRole(User user){
         if(logger.isDebugEnabled()){
             logger.debug("进入该方法"+user);
         }
         return  userService.selByRoleId(user) ;
     }
}
