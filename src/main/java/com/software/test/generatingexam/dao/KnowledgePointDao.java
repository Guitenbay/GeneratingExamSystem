package com.software.test.generatingexam.dao;

import com.software.test.generatingexam.bean.KnowledgePoint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KnowledgePointDao {

    @Select("select id, k_level AS level, number, score, title from knowledge_point where chapter_id = #{chapterId}")
    List<KnowledgePoint> findAllByChapterId(int chapterId);

    @Select("select id, k_level AS level, number, score, title from knowledge_point where id = #{id}")
    KnowledgePoint selectById(int id);

}
