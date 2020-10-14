package com.baidu.gmall.user.controller;


import com.baidu.gmall.UserInfoService;
import com.baidu.gmall.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<UserInfo> findAll(){
        return userInfoService.findAll();
//        return userInfoService.findAllUser();
    }
}
