package com.software.test.generatingexam.controller;

import com.alibaba.fastjson.JSONObject;
import com.software.test.generatingexam.bean.User;
import com.software.test.generatingexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String getUserById(int id) {
        User user = userService.selectUserById(id);
        return JSONObject.toJSONString(user);
    }

    @RequestMapping("/userInfo")
    public String getUserInfoById(int id) {
        return userService.selectUserById(id).toString();
    }


}
