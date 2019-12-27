package com.atguigu.gmalltest.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmalltest.bean.UserAddress;
import com.atguigu.gmalltest.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Reference
    private UserAddressService userAddressService;
    @RequestMapping("/trade")
    public List<UserAddress> trade(String userId){
        return userAddressService.getUserAddressList(userId);
    }
}
