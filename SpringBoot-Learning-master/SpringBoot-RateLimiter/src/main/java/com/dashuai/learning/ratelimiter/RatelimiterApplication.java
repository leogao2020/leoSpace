package com.dashuai.learning.ratelimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RateLimiter应用入口类
 * <p/>
 * 创建于2018年11月19日
 * <p/>
 * 作者：leogao
 */
@SpringBootApplication
public class RatelimiterApplication {

    /**
     * 应用的入口点。
     * @param args 输入的命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(RatelimiterApplication.class, args);
    }
}
