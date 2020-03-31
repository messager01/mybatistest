package com.spx.test;

import com.spx.entities.Customer;
import com.spx.entities.Order;
import com.spx.entities.Teacher;
import com.spx.mapper.CustomerMapper;
import com.spx.mapper.OrderMapper;
import com.spx.mapper.TeacherMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by Shipeixin on 2020/3/30 16:45
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyTest {

    @Autowired
    CustomerMapper  customerMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Value("${emp.name}")
    String name;

    @Test
    public void test(){
        List<Customer> allCustomer = customerMapper.getAllCustomer();
        for (Customer customer : allCustomer) {
            System.out.println(customer);
        }
    }

    @Test
    public void test2(){
        Customer customerById = customerMapper.getCustomerById(2);
        System.out.println(customerById);
    }

    @Test
    public void test3(){
        System.out.println(customerMapper.getCustomerByBlurryName("李"));
    }

    @Test
    public void test4(){
        Customer customer = new Customer();
        customer.setCustName("c");
        customer.setCustProfession("c");
        customer.setCustPhone("15872404075");
        customer.setEmail("273689468@qq.com");
        customerMapper.insertCustomer(customer);
        System.out.println(customer);
    }

    @Test
    public void test5(){
        Customer customer = new Customer();
        customer.setCustId(13);
        customer.setCustName("D");
        customerMapper.updateCustomer(customer);
    }

    @Test
    public void test6(){
         customerMapper.deleteCustomer(13);
    }

    @Test
    public void test7(){
         customerMapper.getCustomerWithIdAndName(2,"李白");
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","鲁班");
        customerMapper.getCustomerWithIdAndName(map);

        Customer customer = new Customer();
        customer.setCustName("阿珂");
        customer.setCustId(3);
        customerMapper.getCustomerWithIdAndName(customer);
    }

    @Test
    public void test8(){
        System.out.println(name);
    }

    @Test
    public void test9(){
        Integer accountCustomer = customerMapper.getAccountCustomer();
        System.out.println(accountCustomer);
    }

    @Test
    public void test10(){
        Map<String, Object> map = customerMapper.getCustomerByID(1);
        System.out.println(map);
    }

    @Test
    public void test11(){
        Map<Integer, Object> customers = customerMapper.getCustomers();
        System.out.println(customers);
    }

//=============== 一对多  多对多  resultmap ==================================================

    @Test
    public void test12(){
        List<Order> allOrder = orderMapper.getAllOrder();
        for (Order order : allOrder) {
            System.out.println(order);
        }
    }


    @Test
    public void test13(){
        Order orderWithId = orderMapper.getOrderWithId(1);
        System.out.println(orderWithId.getOrderName());
    }


    //  一对多添加
    @Test
    public void test14(){
        Order order = new Order();
        order.setOrderName("新订单001");
        order.setOrderNum("2000000001");

        Customer customer = new Customer();
        customer.setCustName("新客户001");
        customer.setCustPhone("4565564565456");
        customer.setEmail("adasd@qq.com");
        customer.setCustProfession("新职业001");


        //  先加一  再加多

        customerMapper.insertCustomer(customer);

        // 设置关系
        order.setCustomer(customer);
        orderMapper.insertOrder(order);
    }


    @Test
    public void test15(){
         orderMapper.breakRelation(6);
         orderMapper.deleteOrderById(6);
         customerMapper.deleteCustomer(15);
    }


    @Test
    public void test16(){
        Teacher teacherByID = teacherMapper.getTeacherByID(1);
        System.out.println(teacherByID);
    }
}
