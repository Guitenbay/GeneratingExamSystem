package com.software.test.generatingexam.dao;

import com.software.test.generatingexam.bean.Chapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChapterDao {

    @Select("select id, title from chapter where syllabus_id = #{syllabusId}")
    List<Chapter> findAllBySyllabusId(int syllabusId);

    @Select("select id, title from chapter where id = #{id}")
    Chapter selectChapterById(int id);
}
