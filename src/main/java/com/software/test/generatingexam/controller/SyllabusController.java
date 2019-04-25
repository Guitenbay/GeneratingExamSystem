package com.software.test.generatingexam.controller;

import com.alibaba.fastjson.JSONObject;
import com.software.test.generatingexam.bean.Syllabus;
import com.software.test.generatingexam.service.SyllabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SyllabusController {

    @Autowired
    SyllabusService syllabusService;

    @RequestMapping("/syllabuses")
    public String getSyllabuses(){
        List<Syllabus> syllabusList = syllabusService.findAll();
        return JSONObject.toJSONString(syllabusList);
    }
}
