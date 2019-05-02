package com.software.test.generatingexam.dao;

import com.software.test.generatingexam.bean.Choice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChoiceDao {

    @Select("select choice_label AS label, content, is_correct_answer AS correct from question_choice where question_id = #{questionId}")
    List<Choice> findAllByQuestionId(int questionId);

    @Select("select choice_label AS label, content, is_correct_answer AS correct from question_choice where id = #{id}")
    Choice selectById(int id);

}
