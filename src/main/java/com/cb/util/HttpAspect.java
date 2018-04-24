package com.cb.util;

import com.cb.pojo.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName HttpAspect
 * @Author redPeanuts
 * @Data 2018/4/10 16:42
 * @Version 1.0
 * @describtion TODO
 **/
@Aspect
@Component
public class HttpAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private ExceptionHandle exceptionHandle;


    @Pointcut("execution(public * com.cb.controller.*.*(..))")
    public void log() {


    }

    @Before("log()")
    public void dobefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        LOGGER.info("url={}", request.getRequestURL());
        //method
        LOGGER.info("method={}", request.getMethod());
        //ip
        LOGGER.info("id={}", request.getRemoteAddr());
        //class_method
        LOGGER.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        //args[]
        LOGGER.info("args={}", joinPoint.getArgs());
        System.out.println("Before");
    }

    @Around("log()")
    public Object doaround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Result result = null;
        try {

        } catch (Exception e) {
            return exceptionHandle.exceptionGet(e);
        }
        if (null== result) {
            return proceedingJoinPoint.proceed();
        } else {
            return result;
        }
    }

    @AfterReturning(pointcut = "log()", returning = "object")//打印输出结果
    public void doAfterReturing(Object object) {

       // LOGGER.info("response={}", object.toString());
    }


}
