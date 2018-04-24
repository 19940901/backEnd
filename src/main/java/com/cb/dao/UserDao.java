package com.cb.dao;

import com.cb.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserDao
 * @Author redPeanuts
 * @Data 2018/4/16 9:02
 * @Version 1.0
 * @describtion mybatis dao层
 **/

@Repository
public interface UserDao {
    void addUser(@Param("name")String name, @Param("password") String pwd);

    UserInfo findById(String id);

    void updateName(@Param("id") String id,@Param("username") String name);

    void deleteUser(String id);

    UserInfo login(@Param("name") String name,@Param("password") String password);

}
