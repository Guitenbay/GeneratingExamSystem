package com.software.test.generatingexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @SpringBootApplication 说明这是一个 SpringBoot 的应用程序
 */
@SpringBootApplication
@ServletComponentScan
public class GeneratingExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneratingExamApplication.class, args);
    }

}
