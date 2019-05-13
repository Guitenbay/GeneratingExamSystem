package com.software.test.generatingexam.controller;

import com.alibaba.fastjson.JSONObject;
import com.software.test.generatingexam.bean.Chapter;
import com.software.test.generatingexam.bean.KnowledgePoint;
import com.software.test.generatingexam.service.ChapterService;
import com.software.test.generatingexam.service.KnowledgePointService;
import com.software.test.generatingexam.service.SyllabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChapterController {

    @Autowired
    ChapterService chapterService;

    @Autowired
    SyllabusService syllabusService;

    @RequestMapping("/chapters")
    public String getChapters(int syllabusId) {
        JSONObject jsonObject = new JSONObject();
        if (syllabusId < 1) {
            jsonObject.put("result", false);
            jsonObject.put("message", "no such id");
            return jsonObject.toJSONString();
        }
        if (syllabusService.getById(syllabusId) == null) {
            jsonObject.put("result", false);
            jsonObject.put("message", "no such syllabus");
            return jsonObject.toJSONString();
        }
        jsonObject.put("result", true);
        jsonObject.put("message", "");
        jsonObject.put("value", chapterService.findAllBySyllabusId(syllabusId));
        return jsonObject.toJSONString();
    }

    @RequestMapping("/chapter")
    public String getChapter(int id) {
        JSONObject jsonObject = new JSONObject();
        if (id < 1) {
            jsonObject.put("result", false);
            jsonObject.put("message", "no such id");
            return jsonObject.toJSONString();
        }
        Chapter chapter = chapterService.selectChapterById(id);
        if (chapter == null) {
            jsonObject.put("result", false);
            jsonObject.put("message", "no such chapter");
            return jsonObject.toJSONString();
        }
        jsonObject.put("result", true);
        jsonObject.put("message", "");
        jsonObject.put("value", JSONObject.toJSONString(chapter));
        return jsonObject.toJSONString();
    }

}
