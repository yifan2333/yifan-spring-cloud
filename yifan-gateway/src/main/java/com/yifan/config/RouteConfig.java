package com.yifan.config;

import java.time.Duration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

import com.yifan.filter.RateLimitByIpGatewayFilter;

/**
 * The type Route config.
 *
 * @author wuyifan
 * @date 2019年12月17日 19:51
 */
@Configuration
public class RouteConfig {

    /**
     * 除了配置文件可以配置路由之外,也可以通过 RouteLocator 配置
     * Custom route locator route locator.
     *
     * @param builder the builder
     * @return the route locator
     * @author wuyifan
     * @date 2019年12月17日 19:51
     */
//    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("yifan-instance", r ->
                        r.path("/yifan-instance/**")
                                .filters(f -> f.stripPrefix(1)
                                    .filter(new RateLimitByIpGatewayFilter(200, 1, Duration.ofSeconds(1))))
                                .uri("lb://YIFAN-INSTANCE")
                                .order(0))
                .build();
    }

}
