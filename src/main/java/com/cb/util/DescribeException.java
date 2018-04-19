package com.cb.util;

import com.cb.pojo.ExceptionEnum;

/**
 * @ClassName DescribeException
 * @Author redPeanuts
 * @Data 2018/4/10 15:52
 * @Version 1.0
 * @describtion 自定义错误信息
 **/

public class DescribeException extends RuntimeException{

    private  Integer code;

    public DescribeException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code=exceptionEnum.getCode();
    }


    /*
    self define error log
     */
    public DescribeException(Integer code,String msg){
        super(msg);
        this.code=code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
