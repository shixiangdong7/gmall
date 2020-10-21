package com.baidu.gmall.service;

import com.baidu.gmall.bean.*;

import java.util.List;

public interface ManageService {


    /**
     * 查询所有的一级分类
     * @return
     */
    List<BaseCatalog1> getCatalog1();


    /**
     * 根据一级分类id查询二级分类
     * @param catalog1Id
     * @return
     */
    List<BaseCatalog2> getCatalog2(String catalog1Id);


    /**
     * 根据二级分类id查询三级分类
     * @param catalog2Id
     * @return
     */
    List<BaseCatalog3> getCatalog3(String catalog2Id);

    /**
     * 根据三级分类id查询平台属性
     * @param catalog3Id
     * @return
     */
    public List<BaseAttrInfo> getAttrList(String catalog3Id);

    /**
     * 保存平台属性对象
     * @param baseAttrInfo
     */
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    /**
     * 根据平台属性值查询平台属性集合
     * @param attrId
     * @return
     */
    List<BaseAttrValue> getAttrValueList(String attrId);

    /**
     * 根据平台属性id查询平台属性对象
     * @param attrId
     * @return
     */
    BaseAttrInfo getAttrInfo(String attrId);

    List<SpuInfo> getSpuInfoList(SpuInfo spuInfo);

    // 查询基本销售属性表
    List<BaseSaleAttr> getBaseSaleAttrList();


    /**
     * 保存spuinfo
     * @param spuInfo
     */
    void saveSpuInfu(SpuInfo spuInfo);

    /**
     * 通过spuimage属性查找spuimage集合
     * @param spuImage
     * @return
     */
    List<SpuImage> getSpuImageList(SpuImage spuImage);

    /**
     * 根据spuid查询销售属性集合
     * @param spuId
     * @return
     */
    List<SpuSaleAttr> getSpuSaleAttrList(String spuId);

    public void saveSkuInfo(SkuInfo skuInfo);

    /**
     * 根据skuid查询skuinfo
     * @param skuId
     * @return
     */
    SkuInfo getSkuInfo(String skuId);


    List<SkuImage> getSkuImageBySkuId(String skuId);

    List<SpuSaleAttr> getSpuSaleAttrListCheckBySku(SkuInfo skuInfo);

    List<SkuSaleAttrValue> getSkuSaleAttrValueListBySpu(String spuId);
}
