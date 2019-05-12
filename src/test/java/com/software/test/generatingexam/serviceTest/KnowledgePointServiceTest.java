package com.software.test.generatingexam.serviceTest;

import com.software.test.generatingexam.baseTest.SpringTestCase;
import com.software.test.generatingexam.bean.KnowledgePoint;
import com.software.test.generatingexam.service.KnowledgePointService;
import com.software.test.generatingexam.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class KnowledgePointServiceTest extends SpringTestCase {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KnowledgePointService knowledgePointService;

    @Test
    public void findAllForNoSuchIdTest() {
        Assert.assertNull(knowledgePointService.findAllByChapterId(-1));
    }

    @Test
    public void findAllForNoSuchChapterTest() {
        Assert.assertNull(knowledgePointService.findAllByChapterId(999));
    }

    @Test
    public void findAllForNoKnowledgePointTest() {
        List<KnowledgePoint> knowledgePointList = knowledgePointService.findAllByChapterId(1258);

        Assert.assertArrayEquals(knowledgePointList.toArray(), new Object[0]);
    }

    @Test
    public void findAllSuccessTest() {
        List<KnowledgePoint> knowledgePointList = knowledgePointService.findAllByChapterId(1);

        Assert.assertTrue(knowledgePointList.size() > 0);
    }

    @Test
    public void selectForNoSuchIdTest() {
        Assert.assertNull(knowledgePointService.selectById(-999));
    }

    @Test
    public void selectForNoSuchKnowledgePointTest() {
        Assert.assertNull(knowledgePointService.selectById(999));
    }

}
