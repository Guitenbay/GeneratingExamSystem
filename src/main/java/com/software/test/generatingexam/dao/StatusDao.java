package com.software.test.generatingexam.dao;

import com.software.test.generatingexam.bean.Status;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StatusDao {

    @Select("select is_finish AS finished, is_start AS started, name from question_status where id = #{id}")
    Status selectById(@Param(value = "id") int id);

}
