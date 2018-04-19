package com.cb.pojo;

/**
 * @ClassName Result
 * @Author redPeanuts
 * @Data 2018/4/10 15:13
 * @Version 1.0
 * @describtion requestResult
 **/

public class Result<T> {
    //status_code 0 is success
    private Integer status;
    // error message
    private String message;
    //content
    private T data;

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
