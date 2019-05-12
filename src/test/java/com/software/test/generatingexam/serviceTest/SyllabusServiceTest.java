package com.software.test.generatingexam.serviceTest;

import com.software.test.generatingexam.baseTest.SpringTestCase;
import com.software.test.generatingexam.bean.Syllabus;
import com.software.test.generatingexam.service.SyllabusService;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;


public class SyllabusServiceTest extends SpringTestCase {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SyllabusService syllabusService;

    @Test
    public void testFindAllSyllabus(){
        List<Syllabus> syllabusList = syllabusService.findAll();
        logger.info(String.format("尝试取出第一个实例的Level：%s", syllabusList.get(0).getLevel()));
        Assert.assertTrue(syllabusList.size() > 0);
    }

    @Test
    public void testFindById(){
        Syllabus syllabus = syllabusService.getById(618);
        Assert.assertEquals("nihao", syllabus.getLevel());
        Assert.assertEquals("test", syllabus.getVersion());
        Assert.assertTrue(syllabus.isDisabled());
    }

    @Test
    public void testInsertSyllabus(){
        String version = UUID.randomUUID().toString();
        String level = UUID.randomUUID().toString();

        Syllabus syllabus = new Syllabus();
        syllabus.setVersion(version);
        syllabus.setLevel(level);
        syllabus.setCreatedOn(new Date());
        syllabus.setUpdatedOn(new Date());
        syllabusService.insert(syllabus);
        syllabus = syllabusService.getById(syllabus.getId());
        Assert.assertEquals(version, syllabus.getVersion());
        Assert.assertEquals(level, syllabus.getLevel());
    }

    @Test
    public void testUpdateVersion(){
        Syllabus syllabus = syllabusService.getById(2414);
        syllabus.setVersion("test_version");
        syllabusService.update("version", syllabus);
        syllabus = syllabusService.getById(syllabus.getId());
        Assert.assertEquals("test_version", syllabus.getVersion());
    }

    @Test
    public void testUpdateLevel(){
        Syllabus syllabus = syllabusService.getById(2414);
        syllabus.setLevel("test_level");
        syllabusService.update("level", syllabus);
        logger.info(String.valueOf(syllabus.getId()));
        syllabus = syllabusService.getById(syllabus.getId());
        Assert.assertEquals("test_level", syllabus.getLevel());
    }

    @Test
    public void testSetDisabled(){
        Syllabus syllabus = syllabusService.getById(2414);
        syllabus.setDisabled(true);
        syllabusService.update("disabled", syllabus);
        syllabus = syllabusService.getById(syllabus.getId());
        Assert.assertTrue(syllabus.isDisabled());
    }

    @Test
    public void testDelete(){
        String version = UUID.randomUUID().toString();
        String level = UUID.randomUUID().toString();

        Syllabus syllabus = new Syllabus();
        syllabus.setVersion(version);
        syllabus.setLevel(level);
        syllabus.setCreatedOn(new Date());
        syllabus.setUpdatedOn(new Date());
        syllabusService.insert(syllabus);

        int prevLength = syllabusService.findAll().size();
        syllabusService.delete(syllabus.getId());
        int length = syllabusService.findAll().size();
        Assert.assertEquals(prevLength, length + 1);
    }
}
