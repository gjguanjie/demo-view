package com.cloud.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProcessModelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIsNull() {
            addCriterion("process_instance_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIsNotNull() {
            addCriterion("process_instance_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdEqualTo(String value) {
            addCriterion("process_instance_id =", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotEqualTo(String value) {
            addCriterion("process_instance_id <>", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdGreaterThan(String value) {
            addCriterion("process_instance_id >", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdGreaterThanOrEqualTo(String value) {
            addCriterion("process_instance_id >=", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLessThan(String value) {
            addCriterion("process_instance_id <", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLessThanOrEqualTo(String value) {
            addCriterion("process_instance_id <=", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLike(String value) {
            addCriterion("process_instance_id like", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotLike(String value) {
            addCriterion("process_instance_id not like", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIn(List<String> values) {
            addCriterion("process_instance_id in", values, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotIn(List<String> values) {
            addCriterion("process_instance_id not in", values, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdBetween(String value1, String value2) {
            addCriterion("process_instance_id between", value1, value2, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotBetween(String value1, String value2) {
            addCriterion("process_instance_id not between", value1, value2, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyIsNull() {
            addCriterion("process_definition_key is null");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyIsNotNull() {
            addCriterion("process_definition_key is not null");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyEqualTo(String value) {
            addCriterion("process_definition_key =", value, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyNotEqualTo(String value) {
            addCriterion("process_definition_key <>", value, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyGreaterThan(String value) {
            addCriterion("process_definition_key >", value, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyGreaterThanOrEqualTo(String value) {
            addCriterion("process_definition_key >=", value, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyLessThan(String value) {
            addCriterion("process_definition_key <", value, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyLessThanOrEqualTo(String value) {
            addCriterion("process_definition_key <=", value, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyLike(String value) {
            addCriterion("process_definition_key like", value, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyNotLike(String value) {
            addCriterion("process_definition_key not like", value, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyIn(List<String> values) {
            addCriterion("process_definition_key in", values, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyNotIn(List<String> values) {
            addCriterion("process_definition_key not in", values, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyBetween(String value1, String value2) {
            addCriterion("process_definition_key between", value1, value2, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyNotBetween(String value1, String value2) {
            addCriterion("process_definition_key not between", value1, value2, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyIsNull() {
            addCriterion("business_key is null");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyIsNotNull() {
            addCriterion("business_key is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyEqualTo(String value) {
            addCriterion("business_key =", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyNotEqualTo(String value) {
            addCriterion("business_key <>", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyGreaterThan(String value) {
            addCriterion("business_key >", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyGreaterThanOrEqualTo(String value) {
            addCriterion("business_key >=", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyLessThan(String value) {
            addCriterion("business_key <", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyLessThanOrEqualTo(String value) {
            addCriterion("business_key <=", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyLike(String value) {
            addCriterion("business_key like", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyNotLike(String value) {
            addCriterion("business_key not like", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyIn(List<String> values) {
            addCriterion("business_key in", values, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyNotIn(List<String> values) {
            addCriterion("business_key not in", values, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyBetween(String value1, String value2) {
            addCriterion("business_key between", value1, value2, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyNotBetween(String value1, String value2) {
            addCriterion("business_key not between", value1, value2, "businessKey");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(String value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(String value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(String value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(String value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(String value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(String value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLike(String value) {
            addCriterion("activity_id like", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotLike(String value) {
            addCriterion("activity_id not like", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<String> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<String> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(String value1, String value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(String value1, String value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andAssigneeUserIsNull() {
            addCriterion("assignee_user is null");
            return (Criteria) this;
        }

        public Criteria andAssigneeUserIsNotNull() {
            addCriterion("assignee_user is not null");
            return (Criteria) this;
        }

        public Criteria andAssigneeUserEqualTo(String value) {
            addCriterion("assignee_user =", value, "assigneeUser");
            return (Criteria) this;
        }

        public Criteria andAssigneeUserNotEqualTo(String value) {
            addCriterion("assignee_user <>", value, "assigneeUser");
            return (Criteria) this;
        }

        public Criteria andAssigneeUserGreaterThan(String value) {
            addCriterion("assignee_user >", value, "assigneeUser");
            return (Criteria) this;
        }

        public Criteria andAssigneeUserGreaterThanOrEqualTo(String value) {
            addCriterion("assignee_user >=", value, "assigneeUser");
            return (Criteria) this;
        }

        public Criteria andAssigneeUserLessThan(String value) {
            addCriterion("assignee_user <", value, "assigneeUser");
            return (Criteria) this;
        }

        public Criteria andAssigneeUserLessThanOrEqualTo(String value) {
            addCriterion("assignee_user <=", value, "assigneeUser");
            return (Criteria) this;
        }

        public Criteria andAssigneeUserLike(String value) {
            addCriterion("assignee_user like", value, "assigneeUser");
            return (Criteria) this;
        }

        public Criteria andAssigneeUserNotLike(String value) {
            addCriterion("assignee_user not like", value, "assigneeUser");
            return (Criteria) this;
        }

        public Criteria andAssigneeUserIn(List<String> values) {
            addCriterion("assignee_user in", values, "assigneeUser");
            return (Criteria) this;
        }

        public Criteria andAssigneeUserNotIn(List<String> values) {
            addCriterion("assignee_user not in", values, "assigneeUser");
            return (Criteria) this;
        }

        public Criteria andAssigneeUserBetween(String value1, String value2) {
            addCriterion("assignee_user between", value1, value2, "assigneeUser");
            return (Criteria) this;
        }

        public Criteria andAssigneeUserNotBetween(String value1, String value2) {
            addCriterion("assignee_user not between", value1, value2, "assigneeUser");
            return (Criteria) this;
        }

        public Criteria andAssigneeGroupIsNull() {
            addCriterion("assignee_group is null");
            return (Criteria) this;
        }

        public Criteria andAssigneeGroupIsNotNull() {
            addCriterion("assignee_group is not null");
            return (Criteria) this;
        }

        public Criteria andAssigneeGroupEqualTo(String value) {
            addCriterion("assignee_group =", value, "assigneeGroup");
            return (Criteria) this;
        }

        public Criteria andAssigneeGroupNotEqualTo(String value) {
            addCriterion("assignee_group <>", value, "assigneeGroup");
            return (Criteria) this;
        }

        public Criteria andAssigneeGroupGreaterThan(String value) {
            addCriterion("assignee_group >", value, "assigneeGroup");
            return (Criteria) this;
        }

        public Criteria andAssigneeGroupGreaterThanOrEqualTo(String value) {
            addCriterion("assignee_group >=", value, "assigneeGroup");
            return (Criteria) this;
        }

        public Criteria andAssigneeGroupLessThan(String value) {
            addCriterion("assignee_group <", value, "assigneeGroup");
            return (Criteria) this;
        }

        public Criteria andAssigneeGroupLessThanOrEqualTo(String value) {
            addCriterion("assignee_group <=", value, "assigneeGroup");
            return (Criteria) this;
        }

        public Criteria andAssigneeGroupLike(String value) {
            addCriterion("assignee_group like", value, "assigneeGroup");
            return (Criteria) this;
        }

        public Criteria andAssigneeGroupNotLike(String value) {
            addCriterion("assignee_group not like", value, "assigneeGroup");
            return (Criteria) this;
        }

        public Criteria andAssigneeGroupIn(List<String> values) {
            addCriterion("assignee_group in", values, "assigneeGroup");
            return (Criteria) this;
        }

        public Criteria andAssigneeGroupNotIn(List<String> values) {
            addCriterion("assignee_group not in", values, "assigneeGroup");
            return (Criteria) this;
        }

        public Criteria andAssigneeGroupBetween(String value1, String value2) {
            addCriterion("assignee_group between", value1, value2, "assigneeGroup");
            return (Criteria) this;
        }

        public Criteria andAssigneeGroupNotBetween(String value1, String value2) {
            addCriterion("assignee_group not between", value1, value2, "assigneeGroup");
            return (Criteria) this;
        }

        public Criteria andBussFlowStateIsNull() {
            addCriterion("buss_flow_state is null");
            return (Criteria) this;
        }

        public Criteria andBussFlowStateIsNotNull() {
            addCriterion("buss_flow_state is not null");
            return (Criteria) this;
        }

        public Criteria andBussFlowStateEqualTo(String value) {
            addCriterion("buss_flow_state =", value, "bussFlowState");
            return (Criteria) this;
        }

        public Criteria andBussFlowStateNotEqualTo(String value) {
            addCriterion("buss_flow_state <>", value, "bussFlowState");
            return (Criteria) this;
        }

        public Criteria andBussFlowStateGreaterThan(String value) {
            addCriterion("buss_flow_state >", value, "bussFlowState");
            return (Criteria) this;
        }

        public Criteria andBussFlowStateGreaterThanOrEqualTo(String value) {
            addCriterion("buss_flow_state >=", value, "bussFlowState");
            return (Criteria) this;
        }

        public Criteria andBussFlowStateLessThan(String value) {
            addCriterion("buss_flow_state <", value, "bussFlowState");
            return (Criteria) this;
        }

        public Criteria andBussFlowStateLessThanOrEqualTo(String value) {
            addCriterion("buss_flow_state <=", value, "bussFlowState");
            return (Criteria) this;
        }

        public Criteria andBussFlowStateLike(String value) {
            addCriterion("buss_flow_state like", value, "bussFlowState");
            return (Criteria) this;
        }

        public Criteria andBussFlowStateNotLike(String value) {
            addCriterion("buss_flow_state not like", value, "bussFlowState");
            return (Criteria) this;
        }

        public Criteria andBussFlowStateIn(List<String> values) {
            addCriterion("buss_flow_state in", values, "bussFlowState");
            return (Criteria) this;
        }

        public Criteria andBussFlowStateNotIn(List<String> values) {
            addCriterion("buss_flow_state not in", values, "bussFlowState");
            return (Criteria) this;
        }

        public Criteria andBussFlowStateBetween(String value1, String value2) {
            addCriterion("buss_flow_state between", value1, value2, "bussFlowState");
            return (Criteria) this;
        }

        public Criteria andBussFlowStateNotBetween(String value1, String value2) {
            addCriterion("buss_flow_state not between", value1, value2, "bussFlowState");
            return (Criteria) this;
        }

        public Criteria andBussEntityCachekeyIsNull() {
            addCriterion("buss_entity_cachekey is null");
            return (Criteria) this;
        }

        public Criteria andBussEntityCachekeyIsNotNull() {
            addCriterion("buss_entity_cachekey is not null");
            return (Criteria) this;
        }

        public Criteria andBussEntityCachekeyEqualTo(String value) {
            addCriterion("buss_entity_cachekey =", value, "bussEntityCachekey");
            return (Criteria) this;
        }

        public Criteria andBussEntityCachekeyNotEqualTo(String value) {
            addCriterion("buss_entity_cachekey <>", value, "bussEntityCachekey");
            return (Criteria) this;
        }

        public Criteria andBussEntityCachekeyGreaterThan(String value) {
            addCriterion("buss_entity_cachekey >", value, "bussEntityCachekey");
            return (Criteria) this;
        }

        public Criteria andBussEntityCachekeyGreaterThanOrEqualTo(String value) {
            addCriterion("buss_entity_cachekey >=", value, "bussEntityCachekey");
            return (Criteria) this;
        }

        public Criteria andBussEntityCachekeyLessThan(String value) {
            addCriterion("buss_entity_cachekey <", value, "bussEntityCachekey");
            return (Criteria) this;
        }

        public Criteria andBussEntityCachekeyLessThanOrEqualTo(String value) {
            addCriterion("buss_entity_cachekey <=", value, "bussEntityCachekey");
            return (Criteria) this;
        }

        public Criteria andBussEntityCachekeyLike(String value) {
            addCriterion("buss_entity_cachekey like", value, "bussEntityCachekey");
            return (Criteria) this;
        }

        public Criteria andBussEntityCachekeyNotLike(String value) {
            addCriterion("buss_entity_cachekey not like", value, "bussEntityCachekey");
            return (Criteria) this;
        }

        public Criteria andBussEntityCachekeyIn(List<String> values) {
            addCriterion("buss_entity_cachekey in", values, "bussEntityCachekey");
            return (Criteria) this;
        }

        public Criteria andBussEntityCachekeyNotIn(List<String> values) {
            addCriterion("buss_entity_cachekey not in", values, "bussEntityCachekey");
            return (Criteria) this;
        }

        public Criteria andBussEntityCachekeyBetween(String value1, String value2) {
            addCriterion("buss_entity_cachekey between", value1, value2, "bussEntityCachekey");
            return (Criteria) this;
        }

        public Criteria andBussEntityCachekeyNotBetween(String value1, String value2) {
            addCriterion("buss_entity_cachekey not between", value1, value2, "bussEntityCachekey");
            return (Criteria) this;
        }

        public Criteria andBussEntityIsNull() {
            addCriterion("buss_entity is null");
            return (Criteria) this;
        }

        public Criteria andBussEntityIsNotNull() {
            addCriterion("buss_entity is not null");
            return (Criteria) this;
        }

        public Criteria andBussEntityEqualTo(String value) {
            addCriterion("buss_entity =", value, "bussEntity");
            return (Criteria) this;
        }

        public Criteria andBussEntityNotEqualTo(String value) {
            addCriterion("buss_entity <>", value, "bussEntity");
            return (Criteria) this;
        }

        public Criteria andBussEntityGreaterThan(String value) {
            addCriterion("buss_entity >", value, "bussEntity");
            return (Criteria) this;
        }

        public Criteria andBussEntityGreaterThanOrEqualTo(String value) {
            addCriterion("buss_entity >=", value, "bussEntity");
            return (Criteria) this;
        }

        public Criteria andBussEntityLessThan(String value) {
            addCriterion("buss_entity <", value, "bussEntity");
            return (Criteria) this;
        }

        public Criteria andBussEntityLessThanOrEqualTo(String value) {
            addCriterion("buss_entity <=", value, "bussEntity");
            return (Criteria) this;
        }

        public Criteria andBussEntityLike(String value) {
            addCriterion("buss_entity like", value, "bussEntity");
            return (Criteria) this;
        }

        public Criteria andBussEntityNotLike(String value) {
            addCriterion("buss_entity not like", value, "bussEntity");
            return (Criteria) this;
        }

        public Criteria andBussEntityIn(List<String> values) {
            addCriterion("buss_entity in", values, "bussEntity");
            return (Criteria) this;
        }

        public Criteria andBussEntityNotIn(List<String> values) {
            addCriterion("buss_entity not in", values, "bussEntity");
            return (Criteria) this;
        }

        public Criteria andBussEntityBetween(String value1, String value2) {
            addCriterion("buss_entity between", value1, value2, "bussEntity");
            return (Criteria) this;
        }

        public Criteria andBussEntityNotBetween(String value1, String value2) {
            addCriterion("buss_entity not between", value1, value2, "bussEntity");
            return (Criteria) this;
        }

        public Criteria andBusinessOperateIsNull() {
            addCriterion("business_operate is null");
            return (Criteria) this;
        }

        public Criteria andBusinessOperateIsNotNull() {
            addCriterion("business_operate is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessOperateEqualTo(String value) {
            addCriterion("business_operate =", value, "businessOperate");
            return (Criteria) this;
        }

        public Criteria andBusinessOperateNotEqualTo(String value) {
            addCriterion("business_operate <>", value, "businessOperate");
            return (Criteria) this;
        }

        public Criteria andBusinessOperateGreaterThan(String value) {
            addCriterion("business_operate >", value, "businessOperate");
            return (Criteria) this;
        }

        public Criteria andBusinessOperateGreaterThanOrEqualTo(String value) {
            addCriterion("business_operate >=", value, "businessOperate");
            return (Criteria) this;
        }

        public Criteria andBusinessOperateLessThan(String value) {
            addCriterion("business_operate <", value, "businessOperate");
            return (Criteria) this;
        }

        public Criteria andBusinessOperateLessThanOrEqualTo(String value) {
            addCriterion("business_operate <=", value, "businessOperate");
            return (Criteria) this;
        }

        public Criteria andBusinessOperateLike(String value) {
            addCriterion("business_operate like", value, "businessOperate");
            return (Criteria) this;
        }

        public Criteria andBusinessOperateNotLike(String value) {
            addCriterion("business_operate not like", value, "businessOperate");
            return (Criteria) this;
        }

        public Criteria andBusinessOperateIn(List<String> values) {
            addCriterion("business_operate in", values, "businessOperate");
            return (Criteria) this;
        }

        public Criteria andBusinessOperateNotIn(List<String> values) {
            addCriterion("business_operate not in", values, "businessOperate");
            return (Criteria) this;
        }

        public Criteria andBusinessOperateBetween(String value1, String value2) {
            addCriterion("business_operate between", value1, value2, "businessOperate");
            return (Criteria) this;
        }

        public Criteria andBusinessOperateNotBetween(String value1, String value2) {
            addCriterion("business_operate not between", value1, value2, "businessOperate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create__date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create__date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create__date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create__date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create__date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create__date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create__date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create__date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create__date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create__date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create__date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create__date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andDelateFlagIsNull() {
            addCriterion("delate_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelateFlagIsNotNull() {
            addCriterion("delate_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelateFlagEqualTo(String value) {
            addCriterion("delate_flag =", value, "delateFlag");
            return (Criteria) this;
        }

        public Criteria andDelateFlagNotEqualTo(String value) {
            addCriterion("delate_flag <>", value, "delateFlag");
            return (Criteria) this;
        }

        public Criteria andDelateFlagGreaterThan(String value) {
            addCriterion("delate_flag >", value, "delateFlag");
            return (Criteria) this;
        }

        public Criteria andDelateFlagGreaterThanOrEqualTo(String value) {
            addCriterion("delate_flag >=", value, "delateFlag");
            return (Criteria) this;
        }

        public Criteria andDelateFlagLessThan(String value) {
            addCriterion("delate_flag <", value, "delateFlag");
            return (Criteria) this;
        }

        public Criteria andDelateFlagLessThanOrEqualTo(String value) {
            addCriterion("delate_flag <=", value, "delateFlag");
            return (Criteria) this;
        }

        public Criteria andDelateFlagLike(String value) {
            addCriterion("delate_flag like", value, "delateFlag");
            return (Criteria) this;
        }

        public Criteria andDelateFlagNotLike(String value) {
            addCriterion("delate_flag not like", value, "delateFlag");
            return (Criteria) this;
        }

        public Criteria andDelateFlagIn(List<String> values) {
            addCriterion("delate_flag in", values, "delateFlag");
            return (Criteria) this;
        }

        public Criteria andDelateFlagNotIn(List<String> values) {
            addCriterion("delate_flag not in", values, "delateFlag");
            return (Criteria) this;
        }

        public Criteria andDelateFlagBetween(String value1, String value2) {
            addCriterion("delate_flag between", value1, value2, "delateFlag");
            return (Criteria) this;
        }

        public Criteria andDelateFlagNotBetween(String value1, String value2) {
            addCriterion("delate_flag not between", value1, value2, "delateFlag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}