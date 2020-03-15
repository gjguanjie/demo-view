package com.cloud.controller;


import com.cloud.service.WorkFlowService;
import com.cloud.utils.ResponseVO;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.bpmn.model.Process;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.repository.Deployment;
import org.flowable.image.ProcessDiagramGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.invoke.MethodHandles;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workFlow")
public class WorkFlowController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Resource
    private WorkFlowService workFlowService;

    @Resource
    private ProcessEngine processEngine;

    /**
     * 注意字体乱码问题
     *
     * @param request
     * @param response
     * @param processId
     */
    @GetMapping("/getProcess")
    public void getProcess(HttpServletRequest request, HttpServletResponse response, String processId) {
        if (StringUtils.isEmpty(processId)) return;
        // 1. 判断当前流程是否完成，若完成，从历史记录中取
        String processDefinitionId = "";
        if (workFlowService.isFinishedProcess(processId)) {
            processDefinitionId = workFlowService.getFinishedProcess(processId);
        } else {
            // 2. 若未完成从运行时记录中取
            processDefinitionId = workFlowService.getCurrentProcess(processId);
        }
        // 3. 获取活动节点
        List<HistoricActivityInstance> activityInstanceList = workFlowService.getActivatedNodeList(processId);
        List<String> activatedNode = activityInstanceList.stream().map(node -> node.getActivityId()).collect(Collectors.toList());
        // 4. 获取流程图
        BpmnModel bpmnModel = workFlowService.getBpmnModel(processDefinitionId);
        ProcessEngineConfiguration engineConfig = processEngine.getProcessEngineConfiguration();
        ProcessDiagramGenerator diagramGenerator = engineConfig.getProcessDiagramGenerator();
        /*InputStream in = diagramGenerator.generateDiagram(bpmnModel, "bmp", activatedNode, Collections.EMPTY_LIST, engineConfig.getActivityFontName(),
                engineConfig.getLabelFontName(), engineConfig.getAnnotationFontName(), engineConfig.getClassLoader(), 1.0);*/
        InputStream in = diagramGenerator.generateDiagram(bpmnModel, "bmp", activatedNode, Collections.EMPTY_LIST, "宋体", "宋体", "宋体", engineConfig.getClassLoader(), 1.0);
        OutputStream out = null;
        byte[] buf = new byte[1024];
        int length = 0;
        try {
            out = response.getOutputStream();
            while ((length = in.read(buf)) != -1) {
                out.write(buf, 0, length);
            }
        } catch (IOException e) {
            LOGGER.error("获取流程图操作异常", e);
        } finally {
            IOUtils.closeQuietly(out);
            IOUtils.closeQuietly(in);
        }
    }

    @PostMapping("/validateProcess")
    public ResponseVO validateProcess(@RequestParam("file") MultipartFile file) {
        ResponseVO<String> responseVO = null;
        XMLStreamReader reader = null;
        InputStream inputStream = null;
        try {
            BpmnXMLConverter bpmnXMLConverter = new BpmnXMLConverter();
            XMLInputFactory factory = XMLInputFactory.newInstance();
            inputStream = file.getInputStream();
            reader = factory.createXMLStreamReader(inputStream);
            BpmnModel model = bpmnXMLConverter.convertToBpmnModel(reader);
            List<Process> processList = model.getProcesses();
            if (CollectionUtils.isEmpty(processList)) {
                LOGGER.error("该文件非流程文件");
                responseVO = ResponseVO.builder().withCode("failed").withMsg("该文件非流程文件").build();
            }
            responseVO = ResponseVO.builder().withCode("success").withMsg("该文件非流程文件").build();
        } catch (Exception ex) {
            responseVO = ResponseVO.builder().withCode("failed").withMsg("该文件非流程文件").build();
        } finally {
            try {
                reader.close();
                IOUtils.closeQuietly(inputStream);
            } catch (Exception ex) {
                responseVO = ResponseVO.builder().withCode("failed").withMsg("该文件非流程文件").build();
            }
            return responseVO;
        }

    }

    @PostMapping("/deployment")
    public ResponseVO createProcess(@RequestParam("file") MultipartFile file) {
        ResponseVO<String> responseVO = null;
        XMLStreamReader reader = null;
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            Deployment deployment = workFlowService.deploymentProcess(file.getOriginalFilename(), inputStream);
            responseVO = ResponseVO.builder().withCode("success").withMsg("deploy success").build();
        } catch (Exception ex) {
            LOGGER.error("部署流程发生异常：{}", ex);
            responseVO = ResponseVO.builder().withCode("failed").withMsg(ex.getMessage()).build();
        }
        return responseVO;
    }
}
