package com.atguigu.gmalltest.service;

import com.atguigu.gmalltest.bean.UserAddress;

import java.util.List;

public interface UserAddressService {
    /**
     * 根据userId查询地址
     * @param userId
     * @return
     */
    List<UserAddress> getUserAddressList(String userId);
}
