package com.software.test.generatingexam.dao;

import com.software.test.generatingexam.bean.Syllabus;
import com.software.test.generatingexam.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select id, username, password, is_admin AS admin, email, full_name, enabled, phone from user where id = #{id}")
    User selectUserById(int id);

    @Select("select * from user")
    List<User> findAll();

    @Update("update user set email = #{email} where id = #{id}")
    int updateEmail(@Param("id") int id, @Param("email") String email);

    @Update("update user set username = #{username} where id = #{id}")
    int updateUsername(@Param("id") int id, @Param("username") String username);

    @Update("update user set full_name = #{full_name} where id = #{id}")
    int updateFullname(@Param("id") int id, @Param("full_name") String full_name);

    @Update("update user set phone = #{phone} where id = #{id}")
    int updatePhone(@Param("id") int id, @Param("phone") String phone);

    @Update("update user set is_admin = #{admin} where id = #{id}")
    int setAdmin(@Param("id") int id, @Param("admin") boolean admin);

    @Update("update user set enabled = #{enabled} where id = #{id}")
    int setEnabled(@Param("id") int id, @Param("enabled") boolean enabled);

    @Delete("delete from user where id = #{id}")
    int delete(@Param("id") int id);
}
