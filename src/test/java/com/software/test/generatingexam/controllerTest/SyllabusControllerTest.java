package com.software.test.generatingexam.controllerTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.software.test.generatingexam.baseTest.SpringTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
public class SyllabusControllerTest extends SpringTestCase {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testForNoSuchId () throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/syllabus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id","-1")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String text = result.getResponse().getContentAsString();

        JSONObject resultObject = JSONObject.parseObject(text);
        Assert.assertEquals("此大纲不存在", resultObject.get("message"));
    }

    @Test
    public void testGetAllSyllabuses () throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/syllabuses")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String text = result.getResponse().getContentAsString();
        JSONArray jsonArray = JSONArray.parseArray(text);
        logger.info(String.format("找到 %d 个大纲对象", jsonArray.size()));
    }



}
