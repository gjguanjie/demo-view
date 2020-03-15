package com.cloud;

import com.cloud.dao.ProcessModelMapper;
import com.cloud.entity.ProcessModel;
import com.cloud.utils.FileUtils;
import com.cloud.workflow.ProcessBusinessKey;
import com.cloud.service.WorkFlowService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoFlowableApplicationTests {

    @Resource
    private RuntimeService runtimeService;

    @Resource
    private TaskService taskService;

    @Resource
    private WorkFlowService workFlowService;

    @Resource
    private ProcessModelMapper processModelMapper;

    @Test
    void contextLoads() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("assign");

        //List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("managerGroup").list();
        //List<Task> tasks1 = taskService.createTaskQuery().processDefinitionKey("test").list();
        /*ProcessInstance processInstance = runtimeService
                .createProcessInstanceQuery()
                .processInstanceId(tasks1.get(0).getProcessInstanceId())
                .singleResult();*/
       /* Task task = taskService.createTaskQuery().processInstanceId(processInstance.getProcessInstanceId()).taskCandidateGroup("managerGroup").active().singleResult();
        taskService.claim(task.getId(),"zhangsan");
        Task taskUser = taskService.createTaskQuery().taskId(task.getId()).singleResult();
        System.out.println(taskUser.getId());
        Map<String,Object> taskMap = new HashMap<>();
        taskMap.put("approved",true);
        taskService.complete(task.getId(),taskMap);*/

        System.out.println();
    }


    @Test
    public void startWorkFlow() {
        String businessKey = "A952700000006";
        ProcessModel processModel = new ProcessModel();
        processModel.setBusinessKey(businessKey);
        processModel.setProcessDefinitionKey(ProcessBusinessKey.ASSIGN_FLOW);
        String processId = runtimeService.createProcessInstanceBuilder()
                .processDefinitionKey(processModel.getProcessDefinitionKey())
                .businessKey(processModel.getBusinessKey())
                .variable(ProcessBusinessKey.PROCESS_EXECUTION_MODEL_VARIABLE_NAME,processModel)
                .start()
                .getProcessInstanceId();
        processModel.setProcessInstanceId(processId);
        processModel.setCreateDate(new Date());
        processModel.setDelateFlag("0");
        processModelMapper.insert(processModel);
        System.out.println("流程ID:" + processId);
    }


    @Test
    public void startSubWorkFlow() {
        String businessKey = "A952710000001";
        ProcessModel processModel = new ProcessModel();
        processModel.setBusinessKey(businessKey);
        processModel.setProcessDefinitionKey(ProcessBusinessKey.ASSIGN_MAIN_PROCESS);
        String processId = runtimeService.createProcessInstanceBuilder()
                .processDefinitionKey(processModel.getProcessDefinitionKey())
                .businessKey(processModel.getBusinessKey())
                .variable(ProcessBusinessKey.PROCESS_EXECUTION_MODEL_VARIABLE_NAME,processModel)
                .start()
                .getProcessInstanceId();
        System.out.println("流程ID:" + processId);
    }

    @Test
    public void findTaskByProcessIdAndTaskDefinitionKey(){
        List<Task> task = taskService.createTaskQuery().processInstanceId("12511").active().taskDefinitionKey("managerApprove").list();
        System.out.println();
    }

    @Test
    public void findTask(){
        List<Task> task = taskService.createTaskQuery().processInstanceId("2501").
                taskDefinitionKey("managerApprove")
                .active()
                .list();
        System.out.println();
    }

    @Test
    public void fileProcess() throws Exception {
        boolean f = FileUtils.existFile("src/main/resources/processes/demo.bpmn20.xml.bak");
        if (f) {
            FileUtils.backupFile("src/main/resources/processes/demo.bpmn20.xml.bak","src/main/resources/processes/demo.bpmn20.xml.bak1");
        } else {
            InputStream inputStream = FileUtils.readFile("src/main/resources/processes/demo.bpmn20.xml.bak");
            FileUtils.writeFile("src/main/resources/processes/demo.bpmn20.xml.bak3",inputStream);
        }


        System.out.println(f);
    }

}
