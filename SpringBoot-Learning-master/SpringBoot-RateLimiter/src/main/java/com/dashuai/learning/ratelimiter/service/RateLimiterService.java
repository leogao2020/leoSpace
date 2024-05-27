package com.dashuai.learning.ratelimiter.service;

import com.google.common.util.concurrent.RateLimiter;


/**
 * 限流服务类，提供创建和获取限流器的接口。
 */
public class RateLimiterService {
    // 限流器实例
    private final RateLimiter rateLimiter;

    /**
     * 构造函数，用于创建限流服务。
     *
     * @param count 限流器允许的请求数量。
     */
    public RateLimiterService(Integer count) {
        // 根据给定的请求数量创建限流器
        this.rateLimiter = RateLimiter.create(count);
    }

    /**
     * 获取限流器实例的方法。
     *
     * @return 返回此服务配置的限流器实例。
     */
    public RateLimiter rateLimiter() {
        return rateLimiter;
    }

}

