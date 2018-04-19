package com.cb.pojo;



public enum ExceptionEnum {
    UNKNOW_ERROR(-1,"UNKNOW_ERROR....."),
    USER_NOT_FOUND(-101,"user_not_found"),
    ;
    private Integer code;

    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
