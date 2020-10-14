package com.baidu.gmall.order.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.baidu.gmall.UserInfoService;
import com.baidu.gmall.bean.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

//    @Autowired
    @Reference
    UserInfoService userInfoService;


    @RequestMapping("trade")
    @ResponseBody
    public List<UserAddress> trade(String userId) {

        return userInfoService.getUserAddressByUserId(userId);
    }
}
