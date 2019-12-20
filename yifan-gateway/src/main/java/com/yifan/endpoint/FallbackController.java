package com.yifan.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * The type Fallback controller.
 *
 * @author wuyifan
 * @date 2019年12月19日 15:59
 */
@RestController
public class FallbackController {

    /**
     * Fallback string.
     *
     * @return the string
     * @author wuyifan
     * @date 2019年12月19日 15:59
     */
    @GetMapping("/fallback")
    @HystrixCommand(commandProperties = {@HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds" ,value ="3000" )})
    public String fallback() {
        return "Hello World!\nfrom gateway";
    }

}
