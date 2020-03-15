package com.cloud.service;

import com.cloud.entity.ProcessModel;
import com.cloud.workflow.ProcessBusinessKey;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.DeploymentBuilder;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

@Service("workFlowService")
public class WorkFlowService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Resource
    private RuntimeService runtimeService;

    @Resource
    private TaskService taskService;

    @Resource
    private HistoryService historyService;

    @Resource
    private RepositoryService repositoryService;

    public String startProcessInstance(ProcessModel processModel) {
        checkProcessParam(processModel);
        String processId = runtimeService.createProcessInstanceBuilder()
                .processDefinitionKey(processModel.getBusinessKey())
                .businessKey(processModel.getBusinessKey())
                .variable(ProcessBusinessKey.PROCESS_EXECUTION_MODEL_VARIABLE_NAME,processModel)
                .start()
                .getProcessInstanceId();
        return processId;
    }

    private void checkProcessParam(ProcessModel processModel) {
        Assert.hasLength(processModel.getProcessDefinitionKey(),"业务流程Key不可为空");
        Assert.hasLength(processModel.getBusinessKey(),"业务Key不可为空");
    }

    public Task findTask(String taskId) {
        return taskService.createTaskQuery()
                .taskId(taskId)
                .singleResult();
    }

    public Task findTask(ProcessModel processModel) {
        TaskQuery taskQuery = taskService.createTaskQuery().processInstanceId(processModel.getProcessInstanceId())
                .taskName(processModel.getTaskName());
        return taskQuery.count() > 0 ? taskQuery.list().get(0) : taskQuery.singleResult();
    }

    public List<ProcessInstance> findProcessInstance(ProcessModel processModel) {
        return runtimeService.createProcessInstanceQuery()
                .processInstanceBusinessKey(processModel.getProcessDefinitionKey())
                .processDefinitionKey(processModel.getBusinessKey()).list();
    }

    public List<Task> findTaskList(ProcessModel processModel) {
        TaskQuery taskQuery = taskService.createTaskQuery();
        if (!StringUtils.isEmpty(processModel.getProcessInstanceId())) {
            taskQuery.processInstanceId(processModel.getProcessInstanceId()).active();
        }
        if (!StringUtils.isEmpty(processModel.getProcessDefinitionKey())) {
            taskQuery.taskCandidateOrAssigned(processModel.getAssigneeUser());
        }
        // 任务名称一不使用，使用切点名称
        if (!CollectionUtils.isEmpty(processModel.getTaskNameList())) {
            taskQuery.taskNameIn(processModel.getTaskNameList());
        }
        if (!StringUtils.isEmpty(processModel.getTaskName())) {
            taskQuery.taskDefinitionKey(processModel.getTaskName());
        }
        if (!StringUtils.isEmpty(processModel.getTaskId())) {
            taskQuery.taskId(processModel.getTaskId());
        }
        return taskQuery.list();
    }

    public boolean isFinishedProcess(String processId) {
        return historyService.createHistoricProcessInstanceQuery().finished().processInstanceId(processId).count() > 0;
    }

    public String getFinishedProcess(String processId) {
        HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery().processDefinitionId(processId).singleResult();
        return processInstance != null ? processInstance.getProcessDefinitionId() : "";
    }

    public String getCurrentProcess(String processId) {
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processId).singleResult();
        return processInstance != null ? processInstance.getProcessDefinitionId() : "";
    }

    public List<HistoricActivityInstance> getActivatedNodeList(String processId) {
        List<HistoricActivityInstance> list =  historyService.createHistoricActivityInstanceQuery().processInstanceId(processId).orderByHistoricActivityInstanceStartTime().asc().list();
        return ObjectUtils.isEmpty(list) ? new ArrayList<>() : list;
    }

    public BpmnModel getBpmnModel(String processDefinitionId) {
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);
        return bpmnModel;
    }

    public Deployment deploymentProcess(String fileName,InputStream inputStream) {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment().name(fileName)
                .addInputStream(fileName,inputStream);

        Deployment deployment= deploymentBuilder.deploy();
        return deployment;
    }
}
