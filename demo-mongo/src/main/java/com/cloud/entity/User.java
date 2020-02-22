package com.cloud.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("t_user")
public class User {

    @Field("_id")
    private ObjectId id;

    @Field("open_id")
    private String openId;

    @Field("shop_id")
    private String shopId;

    @Field("name")
    private String name;


}
