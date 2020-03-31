package com.spx.test;

import com.spx.entities.Customer;
import com.spx.mapper.CustomerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * create by Shipeixin on 2020/3/31 12:16
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class DynamicSQLTest {

    @Autowired
    CustomerMapper customerMapper;

    @Test
    public void test1(){
        List<Customer> customer = customerMapper.getCustomerByNameAndProfession(null, null);
        System.out.println(customer);
    }

    @Test
    public void test2(){
        List<Customer> customersById = customerMapper.getCustomersById(new Integer[] {1,2,3,4,5});
        for (Customer customer : customersById) {
            System.out.println(customer);
        }
    }


}
