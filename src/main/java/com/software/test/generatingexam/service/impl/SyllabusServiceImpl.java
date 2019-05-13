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
    public Syllabus getById(int id) {
        return syllabusDao.getById(id);
    }

    @Override
    public int insert(Syllabus syllabus) {
        return syllabusDao.insert(syllabus);
    }

    @Override
    public int update(String fieldName, Syllabus syllabus) {
        switch (fieldName) {
            case "version":
                return syllabusDao.updateVersion(syllabus.getId(), syllabus.getVersion());
            case "level":
                return syllabusDao.updateLevel(syllabus.getId(), syllabus.getLevel());
            case "disabled":
                return syllabusDao.setDisabled(syllabus.getId(), syllabus.isDisabled());
            default:
                return 0;
        }
    }

    @Override
    public int delete(int id) {
        return syllabusDao.delete(id);
    }


}
