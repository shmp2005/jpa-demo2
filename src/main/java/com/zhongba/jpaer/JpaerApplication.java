package com.zhongba.jpaer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class JpaerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaerApplication.class, args);
    }
}
