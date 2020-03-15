package com.cloud.controller;

import org.apache.servicecomb.pack.omega.context.annotations.SagaStart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.lang.invoke.MethodHandles;

@RestController
@RequestMapping("/saga")
public class SagaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Resource
    private RestTemplate template;

    @GetMapping("/start")
    @SagaStart
    public void start() {
        LOGGER.error("调服务");
        template.postForObject("http://localhost:9001/service/test",null,String.class);
    }

    public void startCancel() {
        LOGGER.error("取消方法");
    }
}
