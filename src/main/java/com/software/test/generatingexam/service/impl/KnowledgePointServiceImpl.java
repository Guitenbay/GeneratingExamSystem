package com.software.test.generatingexam.service.impl;

import com.software.test.generatingexam.bean.KnowledgePoint;
import com.software.test.generatingexam.dao.KnowledgePointDao;
import com.software.test.generatingexam.service.KnowledgePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgePointServiceImpl implements KnowledgePointService {

    @Autowired
    KnowledgePointDao knowledgePointDao;

    @Override
    public List<KnowledgePoint> findAllByChapterId(int chapterId) {
        return knowledgePointDao.findAllByChapterId(chapterId);
    }

    @Override
    public KnowledgePoint selectById(int id) {
        return knowledgePointDao.selectById(id);
    }
}
