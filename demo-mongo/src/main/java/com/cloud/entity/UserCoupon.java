package com.cloud.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserCoupon {

    private String couponId;

    private String userId;

    private String shopId;

    private LocalDateTime drawTime;

    private String drawSource;

    private LocalDateTime createTime;

    private List<User> userList;


}
