package com.yifan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * The type Test controller.
 *
 * @author wuyifan
 * @date 2019年12月19日 11:16
 */
@Slf4j
@RestController
public class TestController {

    /**
     * The Application name.
     */
    @Value("${spring.application.name}")
    private String applicationName;

    /**
     * Test string.
     *
     * @return the string
     * @author wuyifan
     * @date 2019年12月19日 11:16
     */
    @GetMapping("test")
    public String test() {
        log.info("b...........b.............b...........");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.error("异常", e);
        }
        return applicationName + "b";
    }

}
