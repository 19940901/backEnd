package com.cb.service;

import com.cb.pojo.UserInfo;
import com.cb.dao.UserDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    UserDao userDao;



    //    使用mybatis
    public void adduser(@Param("name") String name, @Param("password") String pwd) {
        userDao.addUser(name, pwd);
    }


    public UserInfo findUser(String id) {
        return userDao.findById(id);
    }

    public void update(String name,String id){
        userDao.updateName(id,name);
    }

    public  void deleteUser(String id){
        userDao.deleteUser(id);
    }

    public UserInfo login(String name,String pwd){return userDao.login(name,pwd);}


}
