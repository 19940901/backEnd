package com.cb.util;

/**
 * @ClassName verifyCode
 * @Author redPeanuts
 * @Data 2018/4/18 15:08
 * @Version 1.0
 * @describtion 生成随机取票码
 **/

public class VerifyCode {

    public static String CreateCode(){
        long l = System.currentTimeMillis();
        long l2 = System.currentTimeMillis();
        String s = String.valueOf(l + l2);
        String substring = s.substring(7);
        return substring;

    }

}
