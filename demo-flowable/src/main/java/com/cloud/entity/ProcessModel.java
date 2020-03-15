package com.cloud.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProcessModel implements Serializable {
    private Long id;

    private String processInstanceId;

    private String processDefinitionKey;

    private String businessKey;

    private String taskId;
    /**
     *  taskName对应于节点id,在Task对象中即与taskDefinitionKey，注意区别，flowable中taskName可能定为中文，一般我们不使用这东东为作查询条件，
     */
    private String taskName;

    private List<String> taskNameList;

    private String activityId;

    private String assigneeUser;

    private String assigneeGroup;

    private String bussFlowState;

    private String bussEntityCachekey;

    private String bussEntity;
    // 1.初始
    private String businessOperate;

    private Date createDate;

    private Date updateDate;

    private String delateFlag;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }

    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey == null ? null : processDefinitionKey.trim();
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey == null ? null : businessKey.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public List<String> getTaskNameList() {
        return taskNameList;
    }

    public void setTaskNameList(List<String> taskNameList) {
        this.taskNameList = taskNameList;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public String getAssigneeUser() {
        return assigneeUser;
    }

    public void setAssigneeUser(String assigneeUser) {
        this.assigneeUser = assigneeUser == null ? null : assigneeUser.trim();
    }

    public String getAssigneeGroup() {
        return assigneeGroup;
    }

    public void setAssigneeGroup(String assigneeGroup) {
        this.assigneeGroup = assigneeGroup == null ? null : assigneeGroup.trim();
    }

    public String getBussFlowState() {
        return bussFlowState;
    }

    public void setBussFlowState(String bussFlowState) {
        this.bussFlowState = bussFlowState == null ? null : bussFlowState.trim();
    }

    public String getBussEntityCachekey() {
        return bussEntityCachekey;
    }

    public void setBussEntityCachekey(String bussEntityCachekey) {
        this.bussEntityCachekey = bussEntityCachekey == null ? null : bussEntityCachekey.trim();
    }

    public String getBussEntity() {
        return bussEntity;
    }

    public void setBussEntity(String bussEntity) {
        this.bussEntity = bussEntity == null ? null : bussEntity.trim();
    }

    public String getBusinessOperate() {
        return businessOperate;
    }

    public void setBusinessOperate(String businessOperate) {
        this.businessOperate = businessOperate == null ? null : businessOperate.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelateFlag() {
        return delateFlag;
    }

    public void setDelateFlag(String delateFlag) {
        this.delateFlag = delateFlag == null ? null : delateFlag.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", processInstanceId=").append(processInstanceId);
        sb.append(", processDefinitionKey=").append(processDefinitionKey);
        sb.append(", businessKey=").append(businessKey);
        sb.append(", taskId=").append(taskId);
        sb.append(", taskName=").append(taskName);
        sb.append(", activityId=").append(activityId);
        sb.append(", assigneeUser=").append(assigneeUser);
        sb.append(", assigneeGroup=").append(assigneeGroup);
        sb.append(", bussFlowState=").append(bussFlowState);
        sb.append(", bussEntityCachekey=").append(bussEntityCachekey);
        sb.append(", bussEntity=").append(bussEntity);
        sb.append(", businessOperate=").append(businessOperate);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", delateFlag=").append(delateFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}