package com.software.test.generatingexam.dao;

import com.software.test.generatingexam.bean.Exam;
import com.software.test.generatingexam.bean.QuestionMap;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExamDao {

    @Select("select id, name, user_id AS userId from examination where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "questions", column = "id",
                    many = @Many(select = "com.software.test.generatingexam.dao.ExamDao.findAllByExamId"))
    })
    Exam selectById(int id);

    @Select("select id, name, user_id AS userId from examination where user_id = #{userId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "questions", column = "id",
                    many = @Many(select = "com.software.test.generatingexam.dao.ExamDao.findAllByExamId"))
    })
    List<Exam> findAllByUserId(int userId);

    @Select("select question_id As questionId, number from exam_quest where exam_id = #{examId} order by number")
    List<QuestionMap> findAllByExamId(int examId);

    @Insert("insert into examination(name, user_id) values(#{name}, #{userId})")
    int insert(Exam exam);

    /**
     * 当只有一个参数时，Mapper中可以不使用@Param
     * 但是有多个参数时必须用
     * @param examId
     * @param questionId
     * @param number
     * @return
     */
    @Insert("insert into exam_quest(exam_id, question_id, number) values(#{examId}, #{questionId}, #{number})")
    int insertQuestion(@Param("examId") int examId, @Param("questionId") int questionId, @Param("number") int number);

    /**
     * 当只有一个参数时，Mapper中可以不使用@Param
     * 但是有多个参数时必须用
     * @param examId
     * @param name
     * @return
     */
    @Update("update examination set name = #{name} where id = #{examId}")
    int updateName(@Param("examId") int examId, @Param("name") String name);

    /**
     * 当只有一个参数时，Mapper中可以不使用@Param
     * 但是有多个参数时必须用
     * @param examId
     * @param questionId
     * @param number
     * @return
     */
    @Update("update exam_quest set question_id = #{questionId} where exam_id = #{examId} and number = #{number}")
    int updateQuestion(@Param("examId") int examId, @Param("questionId") int questionId, @Param("number") int number);

}
