package com.cloud.workflow.task;


import org.flowable.task.service.delegate.DelegateTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

/**
 * 方类仅能使用在User Task. 其中一个方要在存在DelegateTask变量，用于获取user task运行时信息
 */

@Component("assignTask")
public class AssignTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public void assign(DelegateTask task) {
        task.setAssignee("managerGroup");
        LOGGER.info("User Task processInstanceId，{}",task.getProcessInstanceId());
        LOGGER.info("User Task Id，{}",task.getId());
    }
}
