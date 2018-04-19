package com.cb.pojo;

public class ExceptionEnumTest {
    public static void main(String[] args) {
        ExceptionEnumTest e=new ExceptionEnumTest();
        e.test(ExceptionEnum.UNKNOW_ERROR);
    }

    public void test(ExceptionEnum e){
        Integer code = e.getCode();
        System.out.println(code);
    }
}