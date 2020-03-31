package com.spx.test;

import com.spx.mapper.CustomerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * create by Shipeixin on 2020/3/31 14:27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CacheTest {

    @Autowired
    CustomerMapper customerMapper;

    @Test
    public void test(){
        Integer accountCustomer = customerMapper.getAccountCustomer();
        System.out.println(accountCustomer);

       /* Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@571a01f9]
        12*/
        Integer accountCustomer1 = customerMapper.getAccountCustomer();
        System.out.println(accountCustomer1);
    }
}
