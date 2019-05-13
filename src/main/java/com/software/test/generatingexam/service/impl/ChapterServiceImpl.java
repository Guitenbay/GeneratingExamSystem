package com.software.test.generatingexam.service.impl;

import com.software.test.generatingexam.bean.Chapter;
import com.software.test.generatingexam.bean.KnowledgePoint;
import com.software.test.generatingexam.dao.ChapterDao;
import com.software.test.generatingexam.dao.KnowledgePointDao;
import com.software.test.generatingexam.dao.SyllabusDao;
import com.software.test.generatingexam.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    SyllabusDao syllabusDao;

    @Autowired
    ChapterDao chapterDao;

    @Override
    public List<Chapter> findAllBySyllabusId(int syllabusId) {
        if (syllabusId < 1) {
            return null;
        }
        if (syllabusDao.selectById(syllabusId) == null) {
            return null;
        }
        return chapterDao.findAllBySyllabusId(syllabusId);
    }

    @Override
    public Chapter selectChapterById(int id) {
        if (id < 1) {
            return null;
        }
        return chapterDao.selectChapterById(id);
    }

}
