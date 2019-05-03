package com.software.test.generatingexam.service;

import com.software.test.generatingexam.bean.Exam;

import java.util.List;

public interface ExamService {

    Exam selectById(int id);

    List<Exam> findAllByUserId(int userId);

    boolean insert(Exam exam);

    boolean update(Exam exam);

}
