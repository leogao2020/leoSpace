package com.dashuai.learning.ratelimiter.config;

import com.dashuai.learning.ratelimiter.service.RateLimiterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 速率限制器配置类
 * 创建于2019.01.08
 *
 * @author LeoGao
 */
@Configuration
public class RateLimiterConfiguration {
    /**
     * 限制次数
     */
    @Value("${limit.count}")
    Integer count;

    /**
     * 创建并返回一个速率限制服务实例。
     * 这个服务将使用配置中指定的限制次数。
     *
     * @return RateLimiterService 速率限制服务实例
     */
    @Bean
    public RateLimiterService rateLimiterService() {
        return new RateLimiterService(count);
    }
}
