package com.atguigu.gmalltest.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmalltest.bean.*;
import com.atguigu.gmalltest.service.ManageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ManageController {
    @Reference
    private ManageService manageService;

    /**
     * 查询第一节点数据
     * @return
     */
    @PostMapping("/getCatalog1")
    public List<BaseCatalog1> getCatalog1(){
        List<BaseCatalog1> baseCatalog1ToList = manageService.getCatalog1();
        return baseCatalog1ToList;
    }

    /**
     * 查询第二节点数据
     * @return
     */
    @PostMapping("/getCatalog2")
    public List<BaseCatalog2> getCatalog2(String catalog1Id){
        List<BaseCatalog2> baseCatalog2ToList = manageService.getCatalog2(catalog1Id);
        return baseCatalog2ToList;
    }

    /**
     * 查询第二节点数据
     * @return
     */
    @PostMapping("/getCatalog3")
    public List<BaseCatalog3> getCatalog3(String catalog2Id){
        List<BaseCatalog3> baseCatalog3ToList = manageService.getCatalog3(catalog2Id);
        return baseCatalog3ToList;
    }
    /**
     * 查询属性数据
     * @return
     */
    @GetMapping("/attrInfoList")
    public List<BaseAttrInfo> attrInfoList(String catalog3Id){
        List<BaseAttrInfo> BaseAttrInfoToList = manageService.getBaseAttrInfo(catalog3Id);
        return BaseAttrInfoToList;
    }
    /**
     * 保存属性名及属性值
     * @return
     */
    @PostMapping("/saveAttrInfo")
    public void saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        manageService.saveAttrInfo(baseAttrInfo);
    }
    /**
     * 获取属性值
     * @return
     */
    @PostMapping("/getAttrValueList")
    public List<BaseAttrValue> getAttrValueList(String attrId){
        //根据业务逻辑,应先获取属性,在利用属性,查询属性值
        List<BaseAttrValue> baseAttrValueList = manageService.getAttrInfoByAttrId(attrId);
        return baseAttrValueList;
    }

}
