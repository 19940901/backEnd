package com.cb.util;

import com.cb.pojo.ExceptionEnum;
import com.cb.pojo.Result;

/**
 * @ClassName ResultUtil
 * @Author redPeanuts
 * @Data 2018/4/10 15:30
 * @Version 1.0
 * @describtion TODO
 **/

public class ResultUtil {
    /*
     * success
     * */
    public static Result success(Object obj) {
        Result result = new Result();
        result.setStatus(0);
        result.setMessage("success");
        result.setData(obj);
        return result;
    }

    /*success without data*/
    public static Result success() {
        return (null);
    }

    /*error with know message*/
    public static Result error(ExceptionEnum exceptionEnum){
        Result result=new Result();
        result.setStatus(exceptionEnum.getCode());
        result.setMessage(exceptionEnum.getMsg());
        result.setData(null);
        return result;
    }

    /*error with unknow message*/
    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setStatus(code);;
        result.setData(null);
        result.setMessage(msg);
        return result;
    }

}
