package com.cloud.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_service_limiter")
@Data
public class ServerLimiter {

    @Id
    private Long id;

    @Column(name = "serviceName")
    private String serviceName;

    @Column(name = "limitCount")
    private Integer limitCount;

    @Column(name = "desc")
    private String desc;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "updateDate")
    private Date updateDate;

    @Column(name = "deleteFlag")
    private String deleteFlag;


}
