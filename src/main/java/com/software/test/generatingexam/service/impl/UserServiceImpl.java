package com.software.test.generatingexam.service.impl;

import com.software.test.generatingexam.bean.Syllabus;
import com.software.test.generatingexam.bean.User;
import com.software.test.generatingexam.dao.UserDao;
import com.software.test.generatingexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserById(int id){
        return userDao.selectUserById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public int update(String fieldName, User user) {
        switch (fieldName) {
            case "email":
                return userDao.updateEmail(user.getId(), user.getEmail());
            case "username":
                return userDao.updateUsername(user.getId(), user.getUsername());
            case "fullname":
                return userDao.updateFullname(user.getId(), user.getFull_name());
            case "phone":
                return userDao.updatePhone(user.getId(), user.getPhone());
            case "admin":
                return userDao.setAdmin(user.getId(), user.isAdmin());
            case "enabled":
                return userDao.setEnabled(user.getId(), user.isEnabled());
            default:
                return 0;
        }
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }

}
