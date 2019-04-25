package com.software.test.generatingexam.service.impl;

import com.software.test.generatingexam.bean.Chapter;
import com.software.test.generatingexam.dao.ChapterDao;
import com.software.test.generatingexam.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    ChapterDao chapterDao;

    @Override
    public List<Chapter> findAllBySyllabusId(int syllabusId) {
        return chapterDao.findAllBySyllabusId(syllabusId);
    }

    @Override
    public Chapter selectChapterById(int id) {
        return chapterDao.selectChapterById(id);
    }
}
