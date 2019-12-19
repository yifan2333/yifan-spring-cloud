package com.yifan.filter;

import java.time.Duration;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * The type Rate limit by ip gateway filter.
 * 自定义实现桶令牌限流
 * 对每个ip地址限流
 *
 * @author wuyifan
 * @date 2019年12月19日 15:28
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateLimitByIpGatewayFilter implements GatewayFilter, Ordered {

    /**
     * The Capacity.
     */
    private int capacity;
    /**
     * The Refill tokens.
     */
    private int refillTokens;
    /**
     * The Refill duration.
     */
    private Duration refillDuration;

    /**
     * The constant CACHE.
     */
    private static final Map<String, Bucket> CACHE = new ConcurrentHashMap<>();

    /**
     * Filter mono.
     *
     * @param exchange the exchange
     * @param chain    the chain
     * @return the mono
     * @author wuyifan
     * @date 2019年12月19日 15:28
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String ip = Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getAddress().getHostAddress();
        Bucket bucket = CACHE.computeIfAbsent(ip, k -> createNewBucket());

        log.info("IP: {}，TokenBucket Available Tokens: {}", ip, bucket.getAvailableTokens());
        if (bucket.tryConsume(1)) {
            return chain.filter(exchange);
        } else {
            exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
            return exchange.getResponse().setComplete();
        }
    }

    /**
     * Gets order.
     *
     * @return the order
     * @author wuyifan
     * @date 2019年12月19日 15:28
     */
    @Override
    public int getOrder() {
        return -1000;
    }


    /**
     * Create new bucket bucket.
     *
     * @return the bucket
     * @author wuyifan
     * @date 2019年12月19日 15:28
     */
    private Bucket createNewBucket() {
        Refill refill = Refill.of(refillTokens, refillDuration);
        Bandwidth limit = Bandwidth.classic(capacity, refill);
        return Bucket4j.builder().addLimit(limit).build();
    }
}
