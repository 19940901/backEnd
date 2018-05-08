package com.cb.service;

import com.cb.dao.ActionDao;
import com.cb.pojo.Order;
import com.cb.pojo.Plan;
import com.cb.pojo.Uorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ActionService
 * @Author redPeanuts
 * @Data 2018/4/18 10:12
 * @Version 1.0
 * @describtion
 **/

@Service
public class ActionService {

    @Autowired
    ActionDao actionDao;

    public List<Order> getOrders(int id) {
       return actionDao.getOrderById(id);
    }

    public List<Plan> getPlans(String name){
        return actionDao.getPlanByName(name);
    }

    public List<String> getSeats(String id){
        return actionDao.getSeatsById(id);
    }

    public void addOrder(Uorder u){
        actionDao.addOrder(u);
    }

    public void addSeats(int plan_id,String seatNumber){
        actionDao.addSeat(plan_id,seatNumber);
    }

    public void updateCode(String code ,int id){
        actionDao.updateCode(code,id);
    }
}
