package com.cb.controller;

import com.cb.pojo.ExceptionEnum;
import com.cb.pojo.Result;
import com.cb.pojo.UserInfo;
import com.cb.service.UserService;
import com.cb.util.DescribeException;
import com.cb.util.ResultUtil;
import com.cb.util.ExceptionHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * post put delete  should add requestBody annotation
 */

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ExceptionHandle exceptionHandle;


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
    

}
