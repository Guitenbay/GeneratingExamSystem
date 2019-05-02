package com.software.test.generatingexam.dao;

import com.software.test.generatingexam.bean.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TypeDao {

    @Select("select id, name from question_type where id = #{id}")
    Type selectById(@Param(value = "id") int id);

    @Select("select id, name from question_type where name = #{name}")
    Type selectByName(@Param(value = "name") String type);

}
