package com.cb.dao;

import com.cb.pojo.Order;
import com.cb.pojo.Plan;
import com.cb.pojo.Uorder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName actionDao
 * @Author redPeanuts
 * @Data 2018/4/18 9:03
 * @Version 1.0
 * @describtion TODO
 **/

@Repository
public interface ActionDao {

    //个人购物车根据userId查order中的seatNumber,movieId,plan_id,state ,verifyCode
    List<Order> getOrderById(int id);

    //场次展示，根据电影名从movie和plan表中查放映信息
    List<Plan> getPlanByName(String name);

    //根据plan信息显示座位信息
    List<String> getSeatsById(String id);

    //新增订单
    void  addOrder(Uorder u);

    //增加订单同时添加seat到hall
    void addSeat(@Param("plan_id") int plan_id, @Param("seatNumber") String seatNumber);

    //生成付款码
    void updateCode(@Param("code") String code,@Param("id") int id);
}
