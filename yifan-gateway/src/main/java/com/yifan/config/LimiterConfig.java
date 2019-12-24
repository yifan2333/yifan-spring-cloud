package com.yifan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yifan.limiter.RemoteAddrKeyResolver;

/**
 * The type Limiter config.
 *
 * @author wuyifan
 * @date 2019年12月24日 11:05
 */
@Configuration
public class LimiterConfig {

    /**
     * Remote addr key resolver remote addr key resolver.
     *
     * @return the remote addr key resolver
     * @author wuyifan
     * @date 2019年12月24日 11:05
     */
    @Bean(name = RemoteAddrKeyResolver.BEAN_NAME)
    public RemoteAddrKeyResolver remoteAddrKeyResolver() {
        return new RemoteAddrKeyResolver();
    }

}
