package com.cb.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UserInfo {

    private Integer user_id;
    private String user_name;
    @NotNull(message = "密码为空")
    @Max(value = 99999999,message = "密码设置错误")
    @Min(value=0,message = "密码设置错误")
    private String password;

    @Override
    public String toString() {
        return "UserInfo{" +
                "uer_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer uer_id) {
        this.user_id = uer_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String username) {
        this.user_name = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
