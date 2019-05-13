package com.software.test.generatingexam.service;

import com.software.test.generatingexam.bean.Syllabus;
import com.software.test.generatingexam.bean.User;

import java.util.List;

public interface UserService {
    User selectUserById(int id);

    List<User> findAll();

    int update(String fieldName, User user);

    int delete(int id);
}
