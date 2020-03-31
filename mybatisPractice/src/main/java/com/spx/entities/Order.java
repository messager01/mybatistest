package com.spx.entities;

import lombok.Data;

/**
 * create by Shipeixin on 2020/3/30 21:31
 */

@Data
public class Order {

    private Integer orderId;

    private String orderName;

    private String orderNum;

    private Customer customer;
}
