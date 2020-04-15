package com.cloud.controller;

import com.cloud.service.SagaService;
import org.apache.servicecomb.pack.omega.transaction.annotations.Compensable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.invoke.MethodHandles;

@RestController
@RequestMapping("service")
public class SagaServiceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().getClass());

    @Resource
    private SagaService sagaService;

    @PostMapping("test")
    public void test(){
        sagaService.test();
    }

    @PostMapping("tccTest")
    public void tccTest(){
        sagaService.tccTest();
    }


}
