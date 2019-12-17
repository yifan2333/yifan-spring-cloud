package com.yifan.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yifan.feign.TestFeign;

import lombok.extern.slf4j.Slf4j;

/** 
 * 
 *
 * @author: wuyifan
 * @since: 2019年11月12日 17:07
 * @version 1.0
 */
@RestController
@Slf4j
public class TestController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Resource
    private TestFeign testFeign;

    @GetMapping("test")
    public String test() {
        log.info("a...........a..........a............");
        System.out.println(testFeign.test());
        return applicationName;
    }

}
