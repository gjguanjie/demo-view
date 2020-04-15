package com.cloud.service;


import org.apache.servicecomb.pack.omega.transaction.annotations.Compensable;
import org.apache.servicecomb.pack.omega.transaction.annotations.Participate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

@Service
public class SagaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().getClass());

    @Compensable(compensationMethod = "cancel")
    public void test() {
        int aa = 1;
        LOGGER.error("测试方法");
        int bb = 1/0;
    }

    public void cancel() {
        LOGGER.error("Cancel方法");
    }

    @Participate(confirmMethod = "confirmTcc", cancelMethod = "cancelTcc")
    public void tccTest() {
        int aa = 1;
        LOGGER.error("测试方法");
    }

    public void confirmTcc() {
        LOGGER.error("confirmTcc方法");
        int bb = 1/0;
    }


    public void cancelTcc() {
        LOGGER.error("cancelTcc方法");
    }



}
