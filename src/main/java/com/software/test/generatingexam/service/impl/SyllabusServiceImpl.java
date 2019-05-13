package com.software.test.generatingexam.service.impl;

import com.software.test.generatingexam.bean.Syllabus;
import com.software.test.generatingexam.dao.SyllabusDao;
import com.software.test.generatingexam.service.SyllabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SyllabusServiceImpl implements SyllabusService {

    @Autowired
    SyllabusDao syllabusDao;

    @Override
    public List<Syllabus> findAll(){
        return syllabusDao.findAll();
    }

    @Override
    public Syllabus selectById(int id) {
        return syllabusDao.selectById(id);
    }
}
