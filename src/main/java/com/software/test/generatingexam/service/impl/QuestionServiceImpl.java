package com.software.test.generatingexam.service.impl;

import com.software.test.generatingexam.bean.Question;
import com.software.test.generatingexam.bean.Type;
import com.software.test.generatingexam.dao.QuestionDao;
import com.software.test.generatingexam.dao.TypeDao;
import com.software.test.generatingexam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionDao questionDao;

    @Autowired
    TypeDao typeDao;

    @Override
    public List<Question> findAllByKnowledgePointId(int knowledgePointId) {
        return questionDao.findAllByKnowledgePointId(knowledgePointId);
    }

    @Override
    public Question selectById(int id) {
        return questionDao.selectById(id);
    }

    @Override
    public List<Question> selectByType(String type) {
        return questionDao.selectByTypeId(typeDao.selectByName(type).getId());
    }
}
