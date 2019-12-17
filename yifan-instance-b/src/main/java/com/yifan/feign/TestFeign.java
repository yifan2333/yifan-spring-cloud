package com.yifan.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/** 
 * 
 *
 * @author: wuyifan
 * @since: 2019年11月12日 17:10
 * @version 1.0
 */
@FeignClient(name = "yifan-instance-a")
public interface TestFeign {

    @GetMapping("test")
    String test();

}
