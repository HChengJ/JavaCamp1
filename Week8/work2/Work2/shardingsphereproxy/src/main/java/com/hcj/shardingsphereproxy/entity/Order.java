package com.hcj.shardingsphereproxy.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Order0)实体类
 *
 * @author makejava
 * @since 2021-08-15 22:53:11
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 599151064793747300L;

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
