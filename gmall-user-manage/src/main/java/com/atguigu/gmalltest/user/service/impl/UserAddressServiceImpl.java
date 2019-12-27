package com.atguigu.gmalltest.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmalltest.bean.UserAddress;
import com.atguigu.gmalltest.service.UserAddressService;
import com.atguigu.gmalltest.user.mapper.UserAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    private UserAddressMapper userAddressMapper;

    /**
     * 根据userId查询地址
     * @param userId
     * @return
     */
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        List<UserAddress> address = userAddressMapper.select(userAddress);
        return address;
    }
}
