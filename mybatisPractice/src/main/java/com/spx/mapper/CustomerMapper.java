package com.spx.mapper;

import com.spx.entities.Customer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * create by Shipeixin on 2020/3/30 16:40
 */
@Mapper
public interface CustomerMapper {

//==============================输  出   类  型  为  简  单  类   型============================================
    // 查询所有
    List<Customer> getAllCustomer();

    // 根据id查询
    Customer getCustomerById(Integer id);

    // 根据用户名模糊查询客户
    List<Customer> getCustomerByBlurryName(String name);

    // 插入客户
    void insertCustomer(Customer customer);

    // 更新客户
    void updateCustomer(Customer customer);

    //  删除客户
    void deleteCustomer(Integer id);




    /**
     *  Available parameters are [arg1, arg0, param1, param2]
     */
    // 使用id和姓名查询（两个参数）
    Customer getCustomerWithIdAndName(@Param("id") Integer id, @Param("name") String name);

    //  传递多个参数  也可使用map传值   方法的重载
    Customer getCustomerWithIdAndName(Map<String,Object> map);


    //   传递多个参数，也可使用POJO类来传值   则 xml中的值必须使用POJO的属性名   不能使用自定义的 id name等
    Customer getCustomerWithIdAndName(Customer customer);


//========================  输   出  类  型  为  MAP ===================================================

        Integer getAccountCustomer();


        // 输出类型为map  (1) key是列名  value是其对应值
        Map<String,Object> getCustomerByID(Integer id);


        // 输出类型为map  使用MapKey注解来表明什么作为key，其中map对应的泛型也就是key的数据类型
        @MapKey("cust_id")
        Map<Integer,Object> getCustomers();


        // 一个客户有多个订单，查询每个客户与其多个相对应的订单
        List<Customer> getAllCustomerAndOrder();


//=====================动态sql==============================================================

    // 需求： 根据客户的 名称和 职业来查询

    List<Customer> getCustomerByNameAndProfession(@Param("name") String name,@Param("profession") String profession);

    // 使用动态sql  进行更新
    void updateCustomerWithDynamicSQL(Customer customer);

    // 根据id  查询指定的客户   有多个客户
     List<Customer>  getCustomersById(Integer[] ids);
}
