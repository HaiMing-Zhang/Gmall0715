package com.atguigu.gmalltest.user.controller;

import com.atguigu.gmalltest.bean.UserInfo;
import com.atguigu.gmalltest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查找所有用户
     * @return
     */
    @RequestMapping("findAll")
    public List<UserInfo> findAll(){
        List<UserInfo> userInfos = userService.fingAll();
        return userInfos;
    }
}
