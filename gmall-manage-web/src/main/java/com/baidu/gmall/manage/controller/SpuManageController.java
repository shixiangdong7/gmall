package com.baidu.gmall.manage.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.baidu.gmall.bean.BaseSaleAttr;
import com.baidu.gmall.bean.SpuImage;
import com.baidu.gmall.bean.SpuInfo;
import com.baidu.gmall.bean.SpuSaleAttr;
import com.baidu.gmall.service.ManageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class SpuManageController {

    @Reference
    ManageService manageService;

    @RequestMapping("baseSaleAttrList")
    public List<BaseSaleAttr>  baseSaleAttrList() {

        List<BaseSaleAttr> baseSaleAttrList = manageService.getBaseSaleAttrList();
        return baseSaleAttrList;
    }

    @RequestMapping("saveSpuInfo")
    public String saveSpuInfo(@RequestBody SpuInfo spuInfo) {

        //保存数据
        manageService.saveSpuInfu(spuInfo);
        return "success";
    }

    @RequestMapping("spuImageList")
    public List<SpuImage> spuImageList(SpuImage spuImage) {
        List<SpuImage> spuImageList = manageService.getSpuImageList(spuImage);
        return spuImageList;

    }

    @RequestMapping("spuSaleAttrList")
    public List<SpuSaleAttr> spuSaleAttrList(String spuId) {
        List<SpuSaleAttr> spuSaleAttrList = manageService.getSpuSaleAttrList(spuId);
        return  spuSaleAttrList;
    }
}
