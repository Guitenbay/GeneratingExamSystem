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

    @RequestMapping("/syllabus")
    public String getSyllabusById(int id){
        JSONObject jsonObject = new JSONObject();
        Syllabus syllabus = syllabusService.getById(id);

        if(syllabus != null){
            jsonObject.put("id", syllabus.getId());
            jsonObject.put("level", syllabus.getLevel());
            jsonObject.put("version", syllabus.getVersion());
            jsonObject.put("createOn", syllabus.getCreatedOn().toString());
            jsonObject.put("updatedOn", syllabus.getUpdatedOn());
        }else {
            jsonObject.put("result", false);
            jsonObject.put("message", "此大纲不存在");
        }
        return jsonObject.toJSONString();
    }
}
