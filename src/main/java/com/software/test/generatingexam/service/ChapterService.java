package com.software.test.generatingexam.service;

import com.software.test.generatingexam.bean.Chapter;

import java.util.List;

public interface ChapterService {

    List<Chapter> findAllBySyllabusId(int syllabusId);

    Chapter selectChapterById(int id);
}
