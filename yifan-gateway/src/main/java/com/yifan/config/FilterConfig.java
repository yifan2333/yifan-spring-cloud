package com.yifan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yifan.filter.ElapsedFilter;
import com.yifan.filter.factory.ElapsedGatewayFilterFactory;

/**
 * The type Filter config.
 *
 * @author wuyifan
 * @date 2019年12月19日 14:24
 */
@Configuration
public class FilterConfig {

//    @Bean
    public ElapsedFilter elapsedFilter() {
        return new ElapsedFilter();
    }

    @Bean
    public ElapsedGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new ElapsedGatewayFilterFactory();
    }
}
