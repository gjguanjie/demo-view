package com.cloud.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderMessage {

    private String orderId;

    private String orderTitle;

    private BigDecimal orderTotalAmount;

    private BigDecimal orderPayAmount;

    private LocalDateTime createDate;

    private LocalDateTime finishDate;

    private LocalDateTime deliveryDate;

    private String orderStatus;

    private String payStatus;

    private String customerId;

    public OrderMessage(String orderId, String orderTitle, BigDecimal orderTotalAmount, BigDecimal orderPayAmount, LocalDateTime createDate, LocalDateTime finishDate, LocalDateTime deliveryDate, String orderStatus, String payStatus, String customerId) {
        this.orderId = orderId;
        this.orderTitle = orderTitle;
        this.orderTotalAmount = orderTotalAmount;
        this.orderPayAmount = orderPayAmount;
        this.createDate = createDate;
        this.finishDate = finishDate;
        this.deliveryDate = deliveryDate;
        this.orderStatus = orderStatus;
        this.payStatus = payStatus;
        this.customerId = customerId;
    }

    public static class Builder {

        private String orderId;

        private String orderTitle;

        private BigDecimal orderTotalAmount;

        private BigDecimal orderPayAmount;

        private LocalDateTime createDate;

        private LocalDateTime finishDate;

        private LocalDateTime deliveryDate;

        private String orderStatus;

        private String payStatus;

        private String customerId;

        public OrderMessage build() {
            return new OrderMessage(this.orderId,this.orderTitle,this.orderTotalAmount,this.orderPayAmount,this.createDate,this.finishDate,this.deliveryDate,this.orderStatus,this.payStatus,this.customerId);
        }

        public Builder withOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder withCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder withCreateDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public Builder withOrderTitle(String orderTitle) {
            this.orderTitle = orderTitle;
            return this;
        }
    }

}
