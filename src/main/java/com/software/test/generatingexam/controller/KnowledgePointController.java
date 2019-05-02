package com.software.test.generatingexam.controller;

import com.alibaba.fastjson.JSONObject;
import com.software.test.generatingexam.service.KnowledgePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KnowledgePointController {

    @Autowired
    KnowledgePointService knowledgePointService;

    @RequestMapping("/kps")
    public String getKnowledgePoints(int chapterId) {
        return JSONObject.toJSONString(knowledgePointService.findAllByChapterId(chapterId));
    }

}
