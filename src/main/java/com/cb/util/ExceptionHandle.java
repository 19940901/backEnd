package com.cb.util;

import com.cb.pojo.ExceptionEnum;
import com.cb.pojo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ExceptionHandle
 * @Author redPeanuts
 * @Data 2018/4/10 16:29
 * @Version 1.0
 * @describtion 切面类，用于处理报错
 **/

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result exceptionGet(Exception e) {
        if (e instanceof DescribeException) {
            DescribeException myException = (DescribeException) e;
            return ResultUtil.error(myException.getCode(), myException.getMessage());
        }
        LOGGER.error("system error", e);
       // System.out.println("记录异常");
        return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);

    }

}
