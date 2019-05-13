package com.software.test.generatingexam.service;

import com.software.test.generatingexam.bean.Syllabus;

import java.util.List;

public interface SyllabusService {

    List<Syllabus> findAll();

    Syllabus selectById(int id);

}
