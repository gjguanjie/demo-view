package com.cloud.controller;

import org.apache.servicecomb.pack.omega.context.annotations.TccStart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tcc")
public class TccController {

    @Resource
    private RestTemplate template;

    @GetMapping("/start")
    @TccStart
    public void start() {
        template.postForObject("http://localhost:9001/service/tccTest",null,String.class);
    }
}
