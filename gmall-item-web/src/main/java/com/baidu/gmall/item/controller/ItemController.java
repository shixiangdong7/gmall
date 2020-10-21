package com.baidu.gmall.item.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.baidu.gmall.bean.SkuImage;
import com.baidu.gmall.bean.SkuInfo;
import com.baidu.gmall.bean.SkuSaleAttrValue;
import com.baidu.gmall.bean.SpuSaleAttr;
import com.baidu.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ItemController {


    @Reference
    ManageService manageService;

    @RequestMapping("{skuId}.html")
    public String skuInfoPage(@PathVariable(value = "skuId") String skuId , HttpServletRequest request){

        SkuInfo skuInfo = manageService.getSkuInfo(skuId);

//        List<SkuImage> skuImageList = manageService.getSkuImageBySkuId(skuId);

//       request.setAttribute("skuImageList",skuImageList);
        request.setAttribute("skuInfo",skuInfo);

        // 存储 spu，sku数据
        List<SpuSaleAttr> saleAttrList = manageService.getSpuSaleAttrListCheckBySku(skuInfo);
        request.setAttribute("saleAttrList",saleAttrList);

        List<SkuSaleAttrValue> skuSaleAttrValueListBySpu = manageService.getSkuSaleAttrValueListBySpu(skuInfo.getSpuId());

        //把列表变换成 valueid1|valueid2|valueid3 ：skuId  的 哈希表 用于在页面中定位查询
        String valueIdsKey="";

        Map<String,String> valuesSkuMap=new HashMap<>();

        for (int i = 0; i < skuSaleAttrValueListBySpu.size(); i++) {
            SkuSaleAttrValue skuSaleAttrValue = skuSaleAttrValueListBySpu.get(i);
            if(valueIdsKey.length()!=0){
                valueIdsKey= valueIdsKey+"|";
            }
            valueIdsKey=valueIdsKey+skuSaleAttrValue.getSaleAttrValueId();

            if((i+1)== skuSaleAttrValueListBySpu.size()||!skuSaleAttrValue.getSkuId().equals(skuSaleAttrValueListBySpu.get(i+1).getSkuId())  ){

                valuesSkuMap.put(valueIdsKey,skuSaleAttrValue.getSkuId());
                valueIdsKey="";
            }

        }
        String valuesSkuJson = JSON.toJSONString(valuesSkuMap);
        request.setAttribute("valuesSkuJson",valuesSkuJson );
        return "item";
    }
}
