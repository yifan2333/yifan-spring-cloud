package com.yifan.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String fallback() {
        return "500";
    }

}
