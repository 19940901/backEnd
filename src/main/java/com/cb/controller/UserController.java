package com.cb.controller;

import com.cb.pojo.ExceptionEnum;
import com.cb.pojo.Result;
import com.cb.pojo.UserInfo;
import com.cb.service.UserService;
import com.cb.util.DescribeException;
import com.cb.util.ResultUtil;
import com.cb.util.ExceptionHandle;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * post put delete  should add requestBody annotation
 */

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    UserInfo userInfo;

    @Autowired
    private UserService userService;

    @Autowired
    private ExceptionHandle exceptionHandle;

    @Autowired
    HttpSession session;


    /*
    mybatis add
     */
    @RequestMapping(value = "add" ,method = RequestMethod.POST)
    public void adduser(String name,String psw){
        userService.adduser(name,psw);
    }


    /*
    mybatis find by id
     */
    @RequestMapping(value="find",method = RequestMethod.GET)
    public UserInfo find(String id){
        return userService.findUser(id);
    }

    /*
   mybatis update by id
    */
    @RequestMapping(value="update",method = RequestMethod.GET)
    public void update(String id,String name){
        userService.update(id,name);
    }


    /*
   mybatis delete by id
    */
    @RequestMapping(value="delete",method = RequestMethod.GET)
    public void delete(String id){
       userService.deleteUser(id);
    }
    
    /*
    login
    */

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //设置返回值编码


        userInfo = userService.login(username, password);
        System.out.println("登录");
        ObjectMapper mapper=new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        if(null==userInfo){
            System.out.println("failed");
           node.put("message","用户名或密码错误");


        }else{
            System.out.println("success");
            session =request.getSession();
            session.setAttribute("user",userInfo);

            node.put("message","success");
        }
       // System.out.println(jj.getValue());
        out.print(node);
    }

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String loginIndex(){
        return "login";
    }

    //sign in failed
    @RequestMapping(value = "failed",method = RequestMethod.POST)
    public String loginFailed(){
        return "用户名或者密码错误";
    }

    @RequestMapping(value = "success" ,method = RequestMethod.GET)
    public String loginSuccess(){
        return "success";
    }
    //sign in success
    @RequestMapping(value = "userInfo",method = RequestMethod.POST)
    public void getMessage(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //设置编码
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //返回登陆success界面，同时添加user信息
        UserInfo users = (UserInfo)session.getAttribute("user");
        ObjectMapper mapper=new ObjectMapper();
        String s=null;
        try {
            s= mapper.writeValueAsString(users);
        } catch (JsonProcessingException e) {
            exceptionHandle.exceptionGet(e);
        }
       out.print(s);
    }


}
