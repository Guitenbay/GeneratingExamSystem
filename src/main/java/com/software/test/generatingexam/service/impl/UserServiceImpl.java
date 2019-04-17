package com.software.test.generatingexam.service.impl;

import com.software.test.generatingexam.bean.User;
import com.software.test.generatingexam.dao.UserDao;
import com.software.test.generatingexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserById(int id){
        return userDao.selectUserById(id);
    }
}
