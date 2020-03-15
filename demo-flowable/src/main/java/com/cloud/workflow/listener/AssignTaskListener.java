package com.cloud.workflow.listener;

import com.cloud.entity.ProcessModel;
import com.cloud.workflow.ProcessBusinessKey;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

/**
 * 注意taskListener的局限性，只能用于UserService,且其生命周期仅在本service有效，若想生效周期全局有效，请使用ExecutionListener
 */

@Component("assignTaskListener")
public class AssignTaskListener implements TaskListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    /**
     *  从流程中取出业务字段即从变量processExecutionModel，可用于任务分配，如不同机构，不同组织
     * @param task
     */
    @Override
    public void notify(DelegateTask task) {
        LOGGER.error("执行任务监听器流程ID，{}",task.getProcessInstanceId());
        LOGGER.error("执行任务监听器任务ID，{}",task.getId());
        ProcessModel processModel = (ProcessModel) task.getVariable(ProcessBusinessKey.PROCESS_EXECUTION_MODEL_VARIABLE_NAME);
        task.setAssignee("managerGroup");

    }
}
