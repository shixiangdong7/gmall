package com.baidu.gmall.manage.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.baidu.gmall.bean.SkuInfo;
import com.baidu.gmall.service.ManageService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class SkuManageController {

    @Reference
    ManageService manageService;

    @RequestMapping("saveSkuInfo")
    public String saveSkuInfo(@RequestBody SkuInfo skuInfo){
        if (skuInfo!=null) {
            manageService.saveSkuInfo(skuInfo);
        }
        return "OK";
    }
}
