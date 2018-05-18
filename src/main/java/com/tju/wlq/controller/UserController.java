package com.tju.wlq.controller;

import com.tju.wlq.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        return "login";
    }

    //用户登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);//会跳到我们自定义的Realm中
            request.getSession().setAttribute("user", user);
            return "success";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            request.getSession().setAttribute("user", user);
            request.setAttribute("error", "用户名或密码错误！");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request) {
        return "success";
    }

    @RequestMapping("/student")
    public String student(HttpServletRequest request) {
        return "success";
    }

    @RequestMapping("/teacher")
    public String teacher(HttpServletRequest request) {
        return "success";
    }




    @RequestMapping(value = "addUser1", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String addUser1(String username, String password) {
        log.info("username = {}, password = {}", username, password);
        return "addUser";
    }
}
