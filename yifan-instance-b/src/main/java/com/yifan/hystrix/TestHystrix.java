package com.yifan.hystrix;

import org.springframework.stereotype.Component;

import com.yifan.feign.TestFeign;

/** 
 * 
 *
 * @author: wuyifan
 * @since: 2019年11月12日 17:28
 * @version 1.0
 */
@Component
public class TestHystrix implements TestFeign {
    @Override
    public String test() {
        return "something wrong";
    }
}
