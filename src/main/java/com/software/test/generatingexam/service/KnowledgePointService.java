package com.software.test.generatingexam.service;

import com.software.test.generatingexam.bean.KnowledgePoint;

import java.util.List;

public interface KnowledgePointService {

    List<KnowledgePoint> findAllByChapterId(int chapterId);

    KnowledgePoint selectById(int id);

}
