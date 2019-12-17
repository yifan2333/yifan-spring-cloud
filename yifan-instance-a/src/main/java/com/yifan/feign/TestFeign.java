package com.yifan.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.yifan.hystrix.TestHystrix;

/** 
 * 
 *
 * @author: wuyifan
 * @since: 2019年11月12日 17:10
 * @version 1.0
 */
@FeignClient(name = "yifan-instance-b", fallback = TestHystrix.class)
public interface TestFeign {

    @GetMapping("test")
    String test();

}
