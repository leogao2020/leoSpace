package com.dashuai.learning.ratelimiter.api;

import com.dashuai.learning.ratelimiter.service.AopTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

/**
 * 请注意：此测试基于编码方式的配置实施测试
 * 测试使用自定义注解的方式进行限流
 */
@RestController
public class RateLimitTestApi {
    @Autowired
    AopTestService aopTestService;

    /**
     * 测试限流注解
     * 无参数
     * @return 返回字符串 "success" 表示测试完成
     */
    @RequestMapping("/")
    public String testApi() {
        rateLimitTest();
        rateLimitTestV2();
        return "success";
    }

    /**
     * 并发测试1：通过自定义注解测试方法的限流效果
     */
    public void rateLimitTest() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        // 创建并启动100个线程，每个线程调用被限流的方法
        for (int i = 0; i <= 100; i++) {
            Business business = new Business(countDownLatch);
            business.start();
        }
        countDownLatch.countDown(); // 允许所有线程继续执行
    }

    // 用于并发测试的内部类
    class Business extends Thread {
        CountDownLatch countDownLatch;

        public Business(CountDownLatch latch) {
            this.countDownLatch = latch;
        }

        @Override
        public void run() {
            try {
                countDownLatch.await(); // 等待计数器归零
                aopTestService.testRateLimiter(5.0, "大傻");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 并发测试2：测试另一种限流场景
     */
    public void rateLimitTestV2() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        // 创建并启动100个线程，每个线程调用被限流的方法
        for (int i = 0; i <= 100; i++) {
            BusinessV2 business = new BusinessV2(countDownLatch);
            business.start();
        }
        countDownLatch.countDown(); // 允许所有线程继续执行
    }

    // 用于并发测试V2的内部类
    class BusinessV2 extends Thread {
        CountDownLatch countDownLatch;

        public BusinessV2(CountDownLatch latch) {
            this.countDownLatch = latch;
        }

        @Override
        public void run() {
            try {
                countDownLatch.await(); // 等待计数器归零
                aopTestService.testRateLimiterv2(10.0, "大傻");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
