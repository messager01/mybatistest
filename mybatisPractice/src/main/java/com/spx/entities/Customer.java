package com.spx.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * create by Shipeixin on 2020/3/30 16:34
 */
@Data
public class Customer implements Serializable {

    private Integer custId;

    private String custName;

    private String custProfession;

    private String custPhone;

    private String email;

    private List<Order> orders;

}
