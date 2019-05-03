package com.software.test.generatingexam.controller;

import com.alibaba.fastjson.JSONObject;
import com.software.test.generatingexam.bean.Exam;
import com.software.test.generatingexam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    ExamService examService;

    @RequestMapping("")
    public String getExamById(int id) {
        return JSONObject.toJSONString(examService.selectById(id));
    }

    @RequestMapping("/all")
    public String getExamsByUserId(HttpSession session) {
        int userId = Integer.parseInt(session.getAttribute("userId").toString());
        return JSONObject.toJSONString(examService.findAllByUserId(userId));
    }


    /**
     * 请求内容是一个 json 串, spring 会自动把他和我们的参数 exam 对应起来,不过要加 @RequestBody 注解
     * @param exam
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateExam(@RequestBody Exam exam) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", examService.update(exam));
        jsonObject.put("message", "");
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/new")
    public String newExam(@RequestParam("name") String name, HttpSession session) {
        Exam exam = new Exam();
        exam.setName(name);
        exam.setUserId(Integer.parseInt(session.getAttribute("userId").toString()));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", examService.insert(exam));
        jsonObject.put("message", "");
        return jsonObject.toJSONString();
    }

}
