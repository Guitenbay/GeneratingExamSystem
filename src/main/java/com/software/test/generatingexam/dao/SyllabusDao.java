package com.software.test.generatingexam.dao;

import com.software.test.generatingexam.bean.Syllabus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SyllabusDao {

    @Select("select id, is_disabled AS disabled, level, version from syllabus")
    List<Syllabus> findAll();

    @Select("select id, is_disabled AS disabled, level, version from syllabus where id = #{id}")
    Syllabus selectById(int id);

}
