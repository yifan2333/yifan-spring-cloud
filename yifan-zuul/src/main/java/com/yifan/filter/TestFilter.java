package com.yifan.filter;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

/** 
 * 
 *
 * @author: wuyifan
 * @since: 2019年11月12日 19:31
 * @version 1.0
 */
@Slf4j
@Component
public class TestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("zuul...............zuul..............");
        return null;
    }
}
