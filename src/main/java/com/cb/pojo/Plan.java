package com.cb.pojo;

/**
 * @ClassName plan
 * @Author redPeanuts
 * @Data 2018/4/18 9:52
 * @Version 1.0
 * @describtion 用户点击某个电影后展示场次
 **/

public class Plan {
    private String startTime;
    private String sumTime;
    private int price;
    private String hall_Name;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getSumTime() {
        return sumTime;
    }

    public void setSumTime(String sumTime) {
        this.sumTime = sumTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getHall_Name() {
        return hall_Name;
    }

    public void setHall_Name(String hall_Name) {
        this.hall_Name = hall_Name;
    }
}
