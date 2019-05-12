package com.software.test.generatingexam.service;

import com.software.test.generatingexam.bean.Syllabus;

import java.util.List;

public interface SyllabusService {

    List<Syllabus> findAll();

    Syllabus getById(int id);

    int insert(Syllabus syllabus);

    int update(String fieldName, Syllabus syllabus);

    int delete(int id);
}
