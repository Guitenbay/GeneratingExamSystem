/**
 * by Mao Haonan
 */
package com.software.test.generatingexam.serviceTest;

import com.software.test.generatingexam.baseTest.SpringTestCase;
import com.software.test.generatingexam.bean.Exam;
import com.software.test.generatingexam.bean.KnowledgePoint;
import com.software.test.generatingexam.service.ExamService;
import com.software.test.generatingexam.service.KnowledgePointService;
import com.software.test.generatingexam.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExamServiceTest extends SpringTestCase {

    @Autowired
    private ExamService examService;

    @Test
    public void findAllForNoSuchIdTest() {
        Assert.assertNull(examService.findAllByUserId(-1));
    }

    @Test
    public void findAllForNoExamTest() {
        List<Exam> examList = examService.findAllByUserId(61);

        Assert.assertArrayEquals(examList.toArray(), new Object[0]);
    }

    @Test
    public void findAllSuccessTest() {
        List<Exam> examList = examService.findAllByUserId(1);

        Assert.assertTrue(examList.size() > 0);
    }

    @Test
    public void selectForNoSuchIdTest() {
        Assert.assertNull(examService.selectById(-999));
    }

    @Test
    public void selectForNoSuchExamTest() {
        Assert.assertNull(examService.selectById(999));
    }

    @Test
    public void insertForNoSuchUserIdTest() {
        Exam exam = new Exam();
        exam.setName("test0");
        exam.setUserId(999);
        Assert.assertTrue(!examService.insert(exam));
    }

}
