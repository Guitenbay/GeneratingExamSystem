package com.software.test.generatingexam.dao;

import com.software.test.generatingexam.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select id, username, password, is_admin AS admin from user where id = #{id}")
    public User selectUserById(int id);
}
