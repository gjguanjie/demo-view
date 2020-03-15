package com.cloud.workflow.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CallExternalSystemDelegate implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void execute(DelegateExecution execution) {
        LOGGER.error("输出成果审批后：{}",execution.getVariable("approved"));
        LOGGER.error("流程ID，{}",execution.getProcessInstanceId());
        LOGGER.error("任务ID，{}",execution.getId());

    }
}
