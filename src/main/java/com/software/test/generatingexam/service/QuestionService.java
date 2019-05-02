package com.software.test.generatingexam.service;

import com.software.test.generatingexam.bean.Question;

import java.util.List;

public interface QuestionService {

    List<Question> findAllByKnowledgePointId(int knowledgePointId);

    Question selectById(int id);

    List<Question> selectByType(String type);

}
