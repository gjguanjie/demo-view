package com.cloud.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document("t_user_coupon")
public class UserCoupon {

    @Id
    @Field("_id")
    private ObjectId id;

    @Field("coupon_id")
    private String couponId;

    @Field("user_id")
    private ObjectId userId;

    @Field("shop_id")
    private String shopId;

    @Field("draw_time")
    private LocalDateTime drawTime;

    @Field("draw_source")
    private String drawSource;

    @Field("create_time")
    private LocalDateTime createTime;

    private List<User> userList;


}
