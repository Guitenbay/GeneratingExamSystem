/**
 * by Cao Mingming
 */
package com.software.test.generatingexam.serviceTest;

import com.software.test.generatingexam.baseTest.SpringTestCase;
import com.software.test.generatingexam.bean.Chapter;
import com.software.test.generatingexam.bean.KnowledgePoint;
import com.software.test.generatingexam.service.ChapterService;
import com.software.test.generatingexam.service.KnowledgePointService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChapterServiceTest extends SpringTestCase {

    @Autowired
    private ChapterService chapterService;

    @Test
    public void findAllForNoSuchIdTest() {
        Assert.assertNull(chapterService.findAllBySyllabusId(-1));
    }

    @Test
    public void findAllForNoSuchSyllabusTest() {
        Assert.assertNull(chapterService.findAllBySyllabusId(999));
    }

    @Test
    public void findAllForNoSyllabusTest() {
        List<Chapter> chapterList = chapterService.findAllBySyllabusId(1229);

        Assert.assertArrayEquals(chapterList.toArray(), new Object[0]);
    }

    @Test
    public void findAllSuccessTest() {
        List<Chapter> chapterList = chapterService.findAllBySyllabusId(1);

        Assert.assertTrue(chapterList.size() > 0);
    }

    @Test
    public void selectForNoSuchIdTest() {
        Assert.assertNull(chapterService.selectChapterById(-999));
    }

    @Test
    public void selectForNoSuchChapterTest() {
        Assert.assertNull(chapterService.selectChapterById(999));
    }

}
