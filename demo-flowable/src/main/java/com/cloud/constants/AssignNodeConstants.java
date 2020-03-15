package com.cloud.constants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum  AssignNodeConstants {

    START("开始","start"),
    MANAGER_APPROVE("经理审批","managerApprove");

    private String name;

    private String value;

    AssignNodeConstants(String name,String value){
        this.name = name;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static List<String> getValues(){
        return Arrays.asList(AssignNodeConstants.values())
                .stream()
                .map(item -> item.getValue())
                .collect(Collectors.toList());
    }

     public static List<String> getNames() {
        return Arrays.asList(AssignNodeConstants.values())
                .stream()
                .map(item -> item.getName())
                .collect(Collectors.toList());
     }
}
