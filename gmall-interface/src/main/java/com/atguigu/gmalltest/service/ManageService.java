package com.atguigu.gmalltest.service;

import com.atguigu.gmalltest.bean.*;

import java.util.List;

public interface ManageService {
    /**
     * 查询第一个节点
     * @return
     */
    List<BaseCatalog1> getCatalog1();

    /**
     * 查询第二个节点
     * @param catalog1Id
     * @return
     */
    List<BaseCatalog2> getCatalog2(String catalog1Id);

    /**
     * 查询第三个节点
     * @param catalog2Id
     * @return
     */
    List<BaseCatalog3> getCatalog3(String catalog2Id);

    /**
     * 查询属性数据
     * @param catalog3Id
     * @return
     */
    List<BaseAttrInfo> getBaseAttrInfo(String catalog3Id);

    /**
     * 保存属性名及属性值
     * @return
     */
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);


    List<BaseAttrValue> getAttrValueByAttrId(String attrId);
    /**
     * 获取属性值,根据业务逻辑,应先获取属性,在利用属性,查询属性值
     * @param attrId
     */
    List<BaseAttrValue> getAttrInfoByAttrId(String attrId);
}
