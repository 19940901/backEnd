package com.cb.controller;

import com.cb.pojo.LoginResult;
import com.cb.pojo.UserInfo;
import com.cb.service.UserService;
import com.cb.util.ExceptionHandle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * post put delete  should add requestBody annotation
 */

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserInfo userInfo;

    @Autowired
    private UserService userService;

    @Autowired
    private ExceptionHandle exceptionHandle;

    @Autowired
    HttpSession session;

    @Autowired
    LoginResult loginResult;


    /*
    mybatis add
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void adduser(String name, String psw) {
        userService.adduser(name, psw);
    }


    /*
    mybatis find by id
     */
    @RequestMapping(value = "find", method = RequestMethod.GET)
    public UserInfo find(String id) {
        return userService.findUser(id);
    }

    /*
   mybatis update by id
    */
    @RequestMapping(value = "update", method = RequestMethod.GET)
    public void update(String id, String name) {
        userService.update(id, name);
    }


    /*
   mybatis delete by id
    */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public void delete(String id) {
        userService.deleteUser(id);
    }
    
    /*
    login
    */

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        // Cookie[] cookies = request.getCookies();
        //Cookie id=new Cookie("id","id");

        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //设置返回值编码


        System.out.println("登录");
        userInfo = userService.login(username, password);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        if (null == userInfo) {
            System.out.println("failed");
            node.put("message", "用户名或密码错误");


        } else {
            System.out.println("success");

            session = request.getSession();
            session.setAttribute("user", userInfo);

            node.put("message", "success");
        }
        // System.out.println(jj.getValue());
        out.print(node);
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String loginIndex() {
        return "login";
    }

    //sign in failed
    @RequestMapping(value = "failed", method = RequestMethod.POST)
    public String loginFailed() {
        return "用户名或者密码错误";
    }

    @RequestMapping(value = "success", method = RequestMethod.GET)
    public String loginSuccess() {
        return "success";
    }


    //sign in success
    @RequestMapping(value = "userInfo", method = RequestMethod.POST)
    public void getMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置编码
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //返回登陆success界面，同时添加user信息
        UserInfo users = (UserInfo) session.getAttribute("user");
        ObjectMapper mapper = new ObjectMapper();
        String s = null;
        try {
            s = mapper.writeValueAsString(users);
        } catch (JsonProcessingException e) {
            exceptionHandle.exceptionGet(e);
        }
        out.print(s);
    }

    @RequestMapping(value = "userlogin", method = RequestMethod.POST)
    public LoginResult userLogin(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        String name;
        String psw;
        UserInfo user;
        Cookie[] cookies = request.getCookies();
        if (null != cookies && cookies.length == 2) {
            if (cookies[0].getName().equals("name") && null != cookies[0].getValue()) {
                name = cookies[0].getValue();
            } else {
                name = request.getParameter("name");
            }

            if (cookies[1].getName().equals("psw") && null != cookies[1].getValue()) {
                psw = cookies[1].getValue();
            } else {
                psw = request.getParameter("psw");
            }
        } else {
            name = request.getParameter("name");
            psw = request.getParameter("psw");
        }
        //如果cookie不为空则用cookie
        //if (null != cookies || cookies.length == 2) {
        // name = cookies[0].getValue();
        //  psw = cookies[1].getValue();
        // } else {


        // }
        user = userService.login(name, psw);


        if (null != user) {
            // response.addCookie(new Cookie("id", String.valueOf(user.getUser_id())));

            response.addCookie(new Cookie("name", name));
            response.addCookie(new Cookie("psw", psw));
            loginResult.setId(String.valueOf(user.getUser_id()));
            loginResult.setName(user.getUser_name());
            loginResult.setState("true");
        } else {
            loginResult.setState("false");
        }
        return loginResult;
    }


}
