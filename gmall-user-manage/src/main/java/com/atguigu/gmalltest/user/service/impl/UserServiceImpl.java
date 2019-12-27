package com.atguigu.gmalltest.user.service.impl;


import com.atguigu.gmalltest.bean.UserInfo;
import com.atguigu.gmalltest.service.UserService;
import com.atguigu.gmalltest.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 查找所有用户
     * @return
     */
    @Override
    public List<UserInfo> fingAll() {
        return userInfoMapper.selectAll();
    }

}
