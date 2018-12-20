package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yuyong on 2018/11/21.
 */

@Controller
@RequestMapping("/loginer")
public class TestDemo {
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String login() {
        return "login";
    }

    @RequestMapping("/loginPage")
    public String login(HttpServletRequest req, HttpSession session) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setPassword(password);
        user.setUserName(username);
        User users = userService.login(user);
        if (null != users && String.valueOf(users) != "") {
            session.setAttribute("name", username);
            return "test";
        }else {
            return "login";
        }
    }
}
