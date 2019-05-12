package com.software.test.generatingexam.controller;

import com.alibaba.fastjson.JSONObject;
import com.software.test.generatingexam.bean.KnowledgePoint;
import com.software.test.generatingexam.dao.KnowledgePointDao;
import com.software.test.generatingexam.service.ChapterService;
import com.software.test.generatingexam.service.KnowledgePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KnowledgePointController {

    @Autowired
    KnowledgePointService knowledgePointService;

    @Autowired
    ChapterService chapterService;

    @RequestMapping("/kps")
    public String getKnowledgePoints(int chapterId) {
        JSONObject jsonObject = new JSONObject();
        if (chapterId < 1) {
            jsonObject.put("result", false);
            jsonObject.put("message", "no such id");
            return jsonObject.toJSONString();
        }
        if (chapterService.selectChapterById(chapterId) == null) {
            jsonObject.put("result", false);
            jsonObject.put("message", "no such chapter");
            return jsonObject.toJSONString();
        }
        jsonObject.put("result", true);
        jsonObject.put("message", "");
        jsonObject.put("value", knowledgePointService.findAllByChapterId(chapterId));
        return jsonObject.toJSONString();
    }

    @RequestMapping("/kp")
    public String getKnowledgePoint(int id) {
        JSONObject jsonObject = new JSONObject();
        if (id < 1) {
            jsonObject.put("result", false);
            jsonObject.put("message", "no such id");
            return jsonObject.toJSONString();
        }
        KnowledgePoint knowledgePoint = knowledgePointService.selectById(id);
        if (knowledgePoint == null) {
            jsonObject.put("result", false);
            jsonObject.put("message", "no such knowledgePoint");
            return jsonObject.toJSONString();
        }
        jsonObject.put("result", true);
        jsonObject.put("message", "");
        jsonObject.put("value", JSONObject.toJSONString(knowledgePoint));
        return jsonObject.toJSONString();
    }

}
