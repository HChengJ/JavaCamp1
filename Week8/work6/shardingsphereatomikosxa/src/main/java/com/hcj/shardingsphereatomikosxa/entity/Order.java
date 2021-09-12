package com.hcj.shardingsphereatomikosxa.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Order0)实体类
 *
 * @author makejava
 * @since 2021-08-19 23:13:57
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = -10754622038644255L;

    private Long orderId;

    private Integer userId;

    private String status;


//    public Long getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(Long orderId) {
//        this.orderId = orderId;
//    }
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

}
