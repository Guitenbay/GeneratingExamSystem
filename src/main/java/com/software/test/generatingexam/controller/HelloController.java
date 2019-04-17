package com.software.test.generatingexam.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @RestController 等价于 @Controller 和 @RequestBody
 */

@RestController
public class HelloController {

    // 建立映射
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

}
