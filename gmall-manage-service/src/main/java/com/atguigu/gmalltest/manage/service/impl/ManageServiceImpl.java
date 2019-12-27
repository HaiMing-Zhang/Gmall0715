package com.atguigu.gmalltest.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmalltest.bean.*;
import com.atguigu.gmalltest.manage.mapper.*;
import com.atguigu.gmalltest.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {
    @Autowired
    private BaseCatalog1Mapper baseCatalog1Mapper;
    @Autowired
    private BaseCatalog2Mapper baseCatalog2Mapper;
    @Autowired
    private BaseCatalog3Mapper baseCatalog3Mapper;
    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;
    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;
    /**
     * 查询第一个节点
     * @return
     */
    @Override
    public List<BaseCatalog1> getCatalog1() {
        List<BaseCatalog1> baseCatalog1List = baseCatalog1Mapper.selectAll();
        return baseCatalog1List;
    }

    /**
     * 查询第二个节点
     * @param catalog1Id
     * @return
     */
    @Override
    public List<BaseCatalog2> getCatalog2(String catalog1Id) {
        BaseCatalog2 baseCatalog2 = new BaseCatalog2();
        baseCatalog2.setCatalog1Id(catalog1Id);
        List<BaseCatalog2> baseCatalog2List = baseCatalog2Mapper.select(baseCatalog2);
        return baseCatalog2List;
    }

    /**
     * 查询第三个节点
     * @param catalog2Id
     * @return
     */
    @Override
    public List<BaseCatalog3> getCatalog3(String catalog2Id) {
        BaseCatalog3 baseCatalog3 = new BaseCatalog3();
        baseCatalog3.setCatalog2Id(catalog2Id);
        List<BaseCatalog3> baseCatalog3List = baseCatalog3Mapper.select(baseCatalog3);
        return baseCatalog3List;
    }
    /**
     * 查询属性数据
     * @param catalog3Id
     * @return
     */
    @Override
    public List<BaseAttrInfo> getBaseAttrInfo(String catalog3Id) {
        BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
        baseAttrInfo.setCatalog3Id(catalog3Id);
        List<BaseAttrInfo> baseAttrInfoList = baseAttrInfoMapper.select(baseAttrInfo);
        return baseAttrInfoList;
    }
    /**
     * 保存属性名及属性值
     * @return
     */
    @Override
    @Transactional
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        if(baseAttrInfo.getId() != null){
            baseAttrInfoMapper.updateByPrimaryKeySelective(baseAttrInfo);
        }else{

            baseAttrInfoMapper.insertSelective(baseAttrInfo);
        }
        BaseAttrValue baseAttrValue1 = new BaseAttrValue();
        baseAttrValue1.setAttrId(baseAttrInfo.getId());
        baseAttrValueMapper.delete(baseAttrValue1);

        List<BaseAttrValue> baseAttrValueList = baseAttrInfo.getAttrValueList();
        if(baseAttrValueList != null && baseAttrValueList.size()>0)
            for (BaseAttrValue baseAttrValue : baseAttrValueList) {
                baseAttrValue.setAttrId(baseAttrInfo.getId());
                baseAttrValueMapper.insertSelective(baseAttrValue);
            }
    }

    /**
     * 根据attrId获取属性值
     * @param attrId
     */
    @Override
    public List<BaseAttrValue> getAttrValueByAttrId(String attrId) {
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(attrId);
        List<BaseAttrValue> baseAttrValueList = baseAttrValueMapper.select(baseAttrValue);
        return baseAttrValueList;
    }
    /**
     * 获取属性值,根据业务逻辑,应先获取属性,在利用属性,查询属性值
     * @param attrId
     */
    @Override
    public List<BaseAttrValue> getAttrInfoByAttrId(String attrId) {
        BaseAttrInfo baseAttrInfo = baseAttrInfoMapper.selectByPrimaryKey(attrId);
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(attrId);
        List<BaseAttrValue> baseAttrValueList = baseAttrValueMapper.select(baseAttrValue);
        baseAttrInfo.setAttrValueList(baseAttrValueList);
        return baseAttrInfo.getAttrValueList();
    }

}
