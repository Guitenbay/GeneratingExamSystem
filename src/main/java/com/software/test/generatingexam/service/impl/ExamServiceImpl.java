package com.software.test.generatingexam.service.impl;

import com.software.test.generatingexam.bean.Exam;
import com.software.test.generatingexam.bean.QuestionMap;
import com.software.test.generatingexam.dao.ExamDao;
import com.software.test.generatingexam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamDao examDao;

    @Override
    public Exam selectById(int id) {
        return examDao.selectById(id);
    }

    @Override
    public boolean insert(Exam exam) {
        return examDao.insert(exam) != 0;
    }

    /**
     *
     * @param exam
     * @return
     */
    @Override
    public boolean update(Exam exam) {
        int examId = exam.getId();
        examDao.updateName(examId, exam.getName());
        List<QuestionMap> questions = exam.getQuestions();
        if (questions == null) {
            return true;
        }
        for (QuestionMap questionMap: questions) {
            // if failed to update questionMap, that means there is not such row
            if (examDao.updateQuestion(examId, questionMap.getQuestionId(), questionMap.getNumber()) == 0) {
                // if failed to insert questionMap
                if (examDao.insertQuestion(examId, questionMap.getQuestionId(), questionMap.getNumber()) == 0) {
                    return false;
                }
            }
        }
        return true;
    }


}
