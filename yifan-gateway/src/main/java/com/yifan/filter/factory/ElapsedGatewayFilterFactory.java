package com.yifan.filter.factory;

import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

import reactor.core.publisher.Mono;

/**
 * The type Elapsed gateway filter factory.
 *
 * @author wuyifan
 * @date 2019年12月19日 14:29
 */
public class ElapsedGatewayFilterFactory extends AbstractGatewayFilterFactory<ElapsedGatewayFilterFactory.Config> {

    /**
     * The constant log.
     */
    private static final Log log = LogFactory.getLog(ElapsedGatewayFilterFactory.class);
    /**
     * The constant ELAPSED_TIME_BEGIN.
     */
    private static final String ELAPSED_TIME_BEGIN = "elapsedTimeBegin";
    /**
     * The constant KEY.
     */
    private static final String KEY = "withParams";

    public ElapsedGatewayFilterFactory() {
        super(Config.class);
    }

    /**
     * Apply gateway filter.
     *
     * @param config the config
     * @return the gateway filter
     * @author wuyifan
     * @date 2019年12月19日 14:29
     */
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            exchange.getAttributes().put(ELAPSED_TIME_BEGIN, System.currentTimeMillis());
            return chain.filter(exchange).then(
                    Mono.fromRunnable(() -> {
                        Long startTime = exchange.getAttribute(ELAPSED_TIME_BEGIN);
                        if (startTime != null) {
                            StringBuilder sb = new StringBuilder(exchange.getRequest().getURI().getRawPath())
                                    .append(": ")
                                    .append(System.currentTimeMillis() - startTime)
                                    .append("ms");
                            if (config.isWithParams()) {
                                sb.append(" params:").append(exchange.getRequest().getQueryParams());
                            }
                            log.info(sb.toString());
                        }
                    })
            );
        };
    }

    /**
     * Shortcut field order list.
     *
     * @return the list
     * @author wuyifan
     * @date 2019年12月19日 14:30
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList(KEY);
    }

    /**
     * The type Config.
     *
     * @author wuyifan
     * @date 2019年12月19日 14:29
     */
    public static class Config {

        /**
         * The With params.
         */
        private boolean withParams;

        /**
         * Is with params boolean.
         *
         * @return the boolean
         * @author wuyifan
         * @date 2019年12月19日 14:29
         */
        public boolean isWithParams() {
            return withParams;
        }

        /**
         * Sets with params.
         *
         * @param withParams the with params
         * @author wuyifan
         * @date 2019年12月19日 14:29
         */
        public void setWithParams(boolean withParams) {
            this.withParams = withParams;
        }

    }
}
