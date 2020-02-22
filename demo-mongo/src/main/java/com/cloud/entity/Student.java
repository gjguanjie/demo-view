package com.cloud.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document("student")
@Data
public class Student {

    @Indexed(unique = true)
    @Field("person_id")
    private Long personId;

    private String school;

    @Field("address_num")
    private String addressNum;

    private List<Address> addressList;
}
