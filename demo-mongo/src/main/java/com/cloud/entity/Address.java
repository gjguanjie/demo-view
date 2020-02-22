package com.cloud.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document("address")
public class Address {

    private String province;

    private String city;

    private String detail;

    private String num;

    @Field("person_id")
    private Long personId;

}
