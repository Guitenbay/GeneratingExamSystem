package com.software.test.generatingexam.dao;

import com.software.test.generatingexam.bean.Question;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface QuestionDao {

    /*fetchType=FetchType.EAGER，如果是EAGER，那么表示取出这条数据时，它关联的数据也同时取出放入内存中,如果是LAZY那么取出这条数据时，它关联的数据并不取出来，在同一个session中，什么时候要用，就什么时候取(再次访问数据库)。
	但是，在session外，就不能再取了。用EAGER时，因为在内存里，所以在session外也可以取。*/
    @Select("select id, stem, difficulty, score, status, type from question where knowledge_point = #{knowledgePointId}")
    @Results({
            // 保证 id 有值
            @Result(property = "id", column = "id"),
            @Result(property = "status", column = "status",
                    one = @One(select = "com.software.test.generatingexam.dao.StatusDao.selectById", fetchType = FetchType.EAGER)),
            @Result(property = "type", column = "type",
                    one = @One(select = "com.software.test.generatingexam.dao.TypeDao.selectById", fetchType = FetchType.EAGER)),
            @Result(property = "choices", column = "id",
                    many = @Many(select = "com.software.test.generatingexam.dao.ChoiceDao.findAllByQuestionId", fetchType = FetchType.EAGER))
    })
    List<Question> findAllByKnowledgePointId(int knowledgePointId);

    @Select("select id, stem, difficulty, score, status, type from question where id = #{id}")
    @Results({
            // 保证 id 有值
            @Result(property = "id", column = "id"),
            @Result(property = "status", column = "status",
                    one = @One(select = "com.software.test.generatingexam.dao.StatusDao.selectById", fetchType = FetchType.EAGER)),
            @Result(property = "type", column = "type",
                    one = @One(select = "com.software.test.generatingexam.dao.TypeDao.selectById", fetchType = FetchType.EAGER)),
            @Result(property = "choices", column = "id",
                    many = @Many(select = "com.software.test.generatingexam.dao.ChoiceDao.findAllByQuestionId", fetchType = FetchType.EAGER))
    })
    Question selectById(int id);


    @Select("select id, stem, difficulty, score, status, type from question where type = #{typeId}")
    @Results({
            // 保证 id 有值
            @Result(property = "id", column = "id"),
            @Result(property = "status", column = "status",
                    one = @One(select = "com.software.test.generatingexam.dao.StatusDao.selectById", fetchType = FetchType.EAGER)),
            @Result(property = "type", column = "type",
                    one = @One(select = "com.software.test.generatingexam.dao.TypeDao.selectById", fetchType = FetchType.EAGER)),
            @Result(property = "choices", column = "id",
                    many = @Many(select = "com.software.test.generatingexam.dao.ChoiceDao.findAllByQuestionId", fetchType = FetchType.EAGER))
    })
    List<Question> selectByTypeId(int typeId);
}
