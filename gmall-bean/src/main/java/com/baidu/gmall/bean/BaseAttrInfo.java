package com.baidu.gmall.bean;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
public class BaseAttrInfo implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String attrName;
    @Column
    private String catalog3Id;

    @Transient//非数据库里的字段，但是业务逻辑需要用，加这个注解
    private List<BaseAttrValue> attrValueList;
}
