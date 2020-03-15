package com.cloud.controller;

import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/config")
public class ConfigController {

    private volatile AtomicInteger count = new AtomicInteger(0);

    @GetMapping("/test")
    @Retryable(maxAttempts=3)
    public String getKey() {
        System.out.println("开始执行次数，" + count.getAndIncrement());
        int aa  = 1/ 0;
        return "";
    }

    @GetMapping("/test1")
    public String getKey1() {
        System.out.println("开始执行次数，" + count.getAndIncrement());
        int aa  = 1/ 0;
        return "";
    }
}
