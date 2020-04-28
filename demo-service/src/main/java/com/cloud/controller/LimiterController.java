package com.cloud.controller;

import com.cloud.limiter.Limiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/limiter")
public class LimiterController {

    @GetMapping("/test")
    public String test() {
        if (Limiter.isLimit("test")) {
            return "aaa";
        } else {
            return "bbb";
        }
    }

    @GetMapping("/rest")
    public String rest() {
        if (Limiter.isLimit("rest")) {
            return "aaa";
        } else {
            return "bbb";
        }
    }
}
