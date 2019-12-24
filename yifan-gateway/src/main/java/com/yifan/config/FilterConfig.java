package com.yifan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yifan.filter.ElapsedFilter;
import com.yifan.filter.factory.ElapsedGatewayFilterFactory;

/**
 * The type Filter config.
 *
 * @author wuyifan
 * @date 2019年12月24日 11:05
 */
@Configuration
public class FilterConfig {

    /**
     * Elapsed filter elapsed filter.
     *
     * @return the elapsed filter
     * @author wuyifan
     * @date 2019年12月24日 11:05
     */
//    @Bean
    public ElapsedFilter elapsedFilter() {
        return new ElapsedFilter();
    }

    /**
     * Elapsed gateway filter factory elapsed gateway filter factory.
     *
     * @return the elapsed gateway filter factory
     * @author wuyifan
     * @date 2019年12月24日 11:05
     */
    @Bean
    public ElapsedGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new ElapsedGatewayFilterFactory();
    }
}
