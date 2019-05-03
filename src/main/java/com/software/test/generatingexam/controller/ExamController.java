package com.software.test.generatingexam.controller;

import com.alibaba.fastjson.JSONObject;
import com.software.test.generatingexam.bean.Exam;
import com.software.test.generatingexam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExamController {

    @Autowired
    ExamService examService;

    @RequestMapping("/exam")
    public String getExamById(int id) {
        return JSONObject.toJSONString(examService.selectById(id));
    }


    /**
     * 请求内容是一个 json 串, spring 会自动把他和我们的参数 exam 对应起来,不过要加 @RequestBody 注解
     * @param exam
     * @return
     */
    @RequestMapping(value = "/updateExam", method = RequestMethod.POST)
    public String updateExam(@RequestBody Exam exam) {
        return JSONObject.toJSONString(examService.update(exam));
    }

    @RequestMapping(value = "/newExam")
    public String newExam(@RequestParam("name") String name, @RequestParam("userId") int userId) {
        Exam exam = new Exam();
        exam.setName(name);
        exam.setUserId(userId);
        return JSONObject.toJSONString(examService.insert(exam));
    }

}
