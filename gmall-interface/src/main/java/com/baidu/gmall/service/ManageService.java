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
}
