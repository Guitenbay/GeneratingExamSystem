package com.software.test.generatingexam.dao;

import com.software.test.generatingexam.bean.Syllabus;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SyllabusDao {
    @Select("select * from syllabus")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "disabled", column = "is_disabled"),
            @Result(property = "createdOn", column = "created_on"),
            @Result(property = "updatedOn", column = "updated_on")
    })
    List<Syllabus> findAll();

    @Select("select * from syllabus where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "disabled", column = "is_disabled"),
            @Result(property = "createdOn", column = "created_on"),
            @Result(property = "updatedOn", column = "updated_on")
    })
    Syllabus getById(int id);

    @Insert("insert into syllabus (level, version, created_on, updated_on) values (#{level}, #{version}, #{createdOn}, #{updatedOn})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Syllabus syllabus);

    @Update("update syllabus set version = #{version} where id = #{id}")
    int updateVersion(@Param("id") int id, @Param("version") String version);

    @Update("update syllabus set level = #{level} where id = #{id}")
    int updateLevel(@Param("id") int id, @Param("level") String level);

    @Update("update syllabus set is_disabled = #{disabled} where id = #{id}")
    int setDisabled(@Param("id") int id, @Param("disabled") boolean disabled);

    @Delete("delete from syllabus where id = #{id}")
    int delete(@Param("id") int id);
}
