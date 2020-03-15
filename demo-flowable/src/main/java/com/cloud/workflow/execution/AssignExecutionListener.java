package com.cloud.workflow.execution;

import org.flowable.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

/**
 * 执行监听器
 */
@Component("assignExecutionListener")
public class AssignExecutionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public void executorService(DelegateExecution execution) {

    }
}
