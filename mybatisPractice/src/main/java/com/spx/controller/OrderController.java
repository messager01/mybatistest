package com.spx.controller;

import com.spx.entities.Customer;
import com.spx.entities.Order;
import com.spx.mapper.CustomerMapper;
import com.spx.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by Shipeixin on 2020/3/30 21:46
 */
@RestController
public class OrderController {


    @Autowired
    OrderMapper orderMapper;

    @Autowired
    CustomerMapper customerMapper;

    @RequestMapping("/getOrders")
    public List<Order> getAllOrders(){
        List<Order> allOrder = orderMapper.getAllOrder();
        return allOrder;
    }

    @RequestMapping("/getCustomers")
    public List<Customer> getAllCustomer(){
        List<Customer> allCustomerAndOrder = customerMapper.getAllCustomerAndOrder();
        return allCustomerAndOrder;
    }
}
