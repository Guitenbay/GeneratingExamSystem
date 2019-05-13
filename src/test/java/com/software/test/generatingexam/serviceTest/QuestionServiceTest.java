/**
 * by Chen Zhibo
 */

package com.software.test.generatingexam.serviceTest;

import com.software.test.generatingexam.baseTest.SpringTestCase;
import com.software.test.generatingexam.bean.Question;
import com.software.test.generatingexam.service.QuestionService;
import com.software.test.generatingexam.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionServiceTest extends SpringTestCase {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QuestionService questionService;

    @Test
    public void testFindAllQuestionNoSuchId() {
        Assert.assertNull(questionService.findAllByKnowledgePointId(-5));
    }

    @Test
    public void testFindAllQuestionBeyondLength() {
        Assert.assertNull(questionService.findAllByKnowledgePointId(9999));
    }

    @Test
    public void testFindAllQuestionNoSuchPoint() {
        List<Question> questionList = questionService.findAllByKnowledgePointId(1229);

        Assert.assertArrayEquals(questionList.toArray(), new Object[0]);
    }

    @Test
    public void testFindAllQuestionSuccess() {
        List<Question> questionList = questionService.findAllByKnowledgePointId(3);

        Assert.assertTrue(questionList.size() > 0);
    }

    @Test
    public void testSelectByIdNoSuchId() {
        Assert.assertNull(questionService.selectById(-13));
    }

    @Test
    public void testSelectByIdBeyondLength() {
        Assert.assertNull(questionService.selectById(99999));
    }

    @Test
    public void testSelectByIdSuccess() {
        Question question = questionService.selectById(2);

        Assert.assertNotNull(question);
    }

    @Test
    public void testSelectByTypeNullInput() {
        Assert.assertNull(questionService.selectByType(null));
    }

    @Test
    public void testSelectByTypeInvalidInput() {
        Assert.assertNull(questionService.selectByType("7893214567"));
    }

    @Test
    public void testSelectByTypeSuccess() {
        List<Question> questionList = questionService.selectByType("情景题");

        Assert.assertTrue(questionList.size() > 0);
    }
}
