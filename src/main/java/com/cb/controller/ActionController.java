package com.cb.controller;

import com.cb.pojo.Order;
import com.cb.pojo.Plan;
import com.cb.pojo.Uorder;
import com.cb.service.ActionService;
import com.cb.util.ExceptionHandle;
import com.cb.util.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ActionController
 * @Author redPeanuts
 * @Data 2018/4/18 10:33
 * @Version 1.0
 * @describtion  与购票相关的逻辑操作
 **/


@RestController
@RequestMapping("act")
public class ActionController {
    @Autowired
    private ExceptionHandle exceptionHandle;

    @Autowired
    ActionService actionService;

    //查询order
    @RequestMapping(value = "orders",method = RequestMethod.POST)
    public List<Order> getOrder(int id){
      return  actionService.getOrders(id);
    }

    //查询plans
    @RequestMapping(value = "plans" ,method = RequestMethod.POST)
    public  List<Plan> getPlans(String name){
        return actionService.getPlans(name);
    }

    //查询seats
    @RequestMapping(value = "seats",method = RequestMethod.POST)
    public List<Integer> getSeats(int plan_id){
        return actionService.getSeats(plan_id);
    }

    //添加order
    @RequestMapping(value = "addOrder",method = RequestMethod.POST)
    public void addOrder(Uorder u){
        actionService.addOrder(u);
        actionService.addSeats(u.getPlan_id(),u.getSeatNumber());
    }

    //用户付款后更新verifyCode
    @RequestMapping(value = "code",method = RequestMethod.POST)
    public String updateCode(String status,int id){
        if(status.equals("ok")) {
            String code = VerifyCode.CreateCode();
            actionService.updateCode(code, id);
            return code;
        }else{
            return "未付款";
        }
    }
}
