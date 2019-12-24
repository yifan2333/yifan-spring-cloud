package com.yifan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * The type Gateway application.
 *
 * @author wuyifan
 * @date 2019年12月24日 11:05
 */
@SpringBootApplication
@EnableHystrix
public class GatewayApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @author wuyifan
     * @date 2019年12月24日 11:05
     */
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
