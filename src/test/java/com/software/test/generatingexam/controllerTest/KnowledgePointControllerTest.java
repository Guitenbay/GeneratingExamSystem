/**
 * by Mao Haonan
 */
package com.software.test.generatingexam.controllerTest;

import com.alibaba.fastjson.JSONObject;
import com.software.test.generatingexam.baseTest.SpringTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
public class KnowledgePointControllerTest extends SpringTestCase {

    @Autowired
    private MockMvc mockMvc; //只需 autowire

    @Test
    public void getKnowledgePointsForNoSuchIdTest () throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/kps")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("chapterId","-1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String text = result.getResponse().getContentAsString();

        JSONObject resultObject = JSONObject.parseObject(text);
        Assert.assertEquals("no such id", resultObject.get("message"));
    }

    @Test
    public void getKnowledgePointsForNoSuchChapterTest () throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/kps")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("chapterId","999")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String text = result.getResponse().getContentAsString();

        JSONObject resultObject = JSONObject.parseObject(text);
        Assert.assertEquals("no such chapter", resultObject.get("message"));
    }

    @Test
    public void getKnowledgePointsForNoSuchKnowledgePointTest () throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/kps")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("chapterId","2388")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String text = result.getResponse().getContentAsString();

        JSONObject resultObject = JSONObject.parseObject(text);

        Assert.assertEquals("[]", resultObject.get("value").toString());
    }

    @Test
    public void getKnowledgePointForNoSuchIdTest () throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/kp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id","-999")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String text = result.getResponse().getContentAsString();

        JSONObject resultObject = JSONObject.parseObject(text);

        Assert.assertEquals("no such id", resultObject.get("message"));
    }

    @Test
    public void getKnowledgePointForNoSuchKnowledgePointTest () throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/kp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id","999")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String text = result.getResponse().getContentAsString();

        JSONObject resultObject = JSONObject.parseObject(text);

        Assert.assertEquals("no such knowledgePoint", resultObject.get("message"));
    }

}
