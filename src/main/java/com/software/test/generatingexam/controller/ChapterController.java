package com.software.test.generatingexam.controller;

import com.alibaba.fastjson.JSONObject;
import com.software.test.generatingexam.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChapterController {

    @Autowired
    ChapterService chapterService;

    @RequestMapping("/chapters")
    public String getChapters(int syllabusId) {
        return JSONObject.toJSONString(chapterService.findAllBySyllabusId(syllabusId));
    }

    @RequestMapping("/chapter")
    public String getChapter(int id) {
        return JSONObject.toJSONString(chapterService.selectChapterById(id));
    }
}
