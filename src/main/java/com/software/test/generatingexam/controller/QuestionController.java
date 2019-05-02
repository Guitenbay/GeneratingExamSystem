package com.software.test.generatingexam.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.software.test.generatingexam.bean.Question;
import com.software.test.generatingexam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping("/question")
    public String getQuestionById(int id) {
        Question question = questionService.selectById(id);

        return JSONObject.toJSONString(question);
    }

    @RequestMapping("/questions")
    public String getQuestionsByKnowledgePoint(int kpId) {
        List<Question> questions = questionService.findAllByKnowledgePointId(kpId);

        /**
         * com.alibaba.fastjson.JSONObject循环给同一对象赋值会出现"$ref":"$[0]"现象问题
         * 正确的做法之一为，关闭检测
         * SerializerFeature.DisableCircularReferenceDetect
         */
        return JSONObject.toJSONString(questions, SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping("/questionsByType")
    public String getQuestionsByType(String type) {
        return JSONObject.toJSONString(questionService.selectByType(type));
    }

}
