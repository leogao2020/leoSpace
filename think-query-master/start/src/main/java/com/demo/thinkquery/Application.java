package com.demo.thinkquery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@SpringBootApplication(scanBasePackages = {"com.demo.thinkquery", "com.alibaba.cola"})
@MapperScan(basePackages = "com.demo.thinkquery.user")
@MapperScan(basePackages = "com.demo.thinkquery.customer")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
