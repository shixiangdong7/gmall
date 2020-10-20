package com.baidu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baidu.gmall.bean.*;
import com.baidu.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class ManageController {

    @Reference
    private ManageService manageService;

    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<BaseCatalog1> getCatalog1(){
        return manageService.getCatalog1();
    }

    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<BaseCatalog2> getCatalog2(String catalog1Id){
        return manageService.getCatalog2(catalog1Id);
    }

    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<BaseCatalog3> getCatalog3(String catalog2Id){
        return manageService.getCatalog3(catalog2Id);
    }

    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<BaseAttrInfo> attrInfoList(String catalog3Id){
        return manageService.getAttrList(catalog3Id);
    }

    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<BaseAttrValue> getAttrValueList(String attrId) {

        BaseAttrInfo attrInfo = manageService.getAttrInfo(attrId);
        List<BaseAttrValue> attrValueList = attrInfo.getAttrValueList();
        return attrValueList;
    }

    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public void saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo) {
        manageService.saveAttrInfo(baseAttrInfo);
    }

    @RequestMapping("spuList")
    @ResponseBody
    public List<SpuInfo> spuList(String catalog3Id){
        SpuInfo spuInfo = new SpuInfo();
        spuInfo.setCatalog3Id(catalog3Id);
        List<SpuInfo> spuInfoList = manageService.getSpuInfoList(spuInfo);
        return  spuInfoList;
    }

}
