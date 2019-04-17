package com.software.test.generatingexam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 说明这是一个 SpringBoot 的应用程序
 */
@SpringBootApplication
public class GeneratingExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneratingExamApplication.class, args);
    }

}
