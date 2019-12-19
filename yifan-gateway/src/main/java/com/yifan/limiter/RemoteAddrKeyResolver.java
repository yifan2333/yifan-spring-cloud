package com.yifan.limiter;

import java.util.Objects;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * The type Remote addr key resolver.
 *
 * @author wuyifan
 * @date 2019年12月19日 15:32
 */
public class RemoteAddrKeyResolver implements KeyResolver {

    /**
     * The constant BEAN_NAME.
     */
    public static final String BEAN_NAME = "remoteAddrKeyResolver";

    /**
     * Resolve mono.
     *
     * @param exchange the exchange
     * @return the mono
     * @author wuyifan
     * @date 2019年12月19日 15:32
     */
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getAddress().getHostAddress());
    }
}
