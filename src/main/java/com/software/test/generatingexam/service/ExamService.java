package com.software.test.generatingexam.service;

import com.software.test.generatingexam.bean.Exam;

public interface ExamService {

    Exam selectById(int id);

    boolean insert(Exam exam);

    boolean update(Exam exam);

}
