package com.atguigu.gmalltest.service;

import com.atguigu.gmalltest.bean.UserInfo;

import java.util.List;

public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    List<UserInfo> fingAll();


}
