package com.example.hotel.controller.admin;

import com.example.hotel.controller.hotel.HotelController;
import com.example.hotel.po.User;
import com.example.hotel.vo.HotelVO;
import com.example.hotel.vo.ResponseVO;
import com.example.hotel.vo.UserForm;
import com.example.hotel.vo.UserVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/** 
* AdminController Tester. 
* 
* @author <Authors name> 
* @since <pre>6�� 22, 2020</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest

//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class AdminControllerTest {
    @Autowired
    private AdminController adminController;
@Before
public void before() throws Exception {
    System.out.println("开始测试-----------------");
} 

@After
public void after() throws Exception {
    System.out.println("测试结束-----------------");
} 

/** 
* 
* Method: addManager(@RequestBody UserForm userForm) 
* 
*/ 
@Test
@Transactional
public void testAddManager() throws Exception { 
//TODO: Test goes here...
    UserForm userForm=new UserForm();
    userForm.setEmail("119@qq.com");
    userForm.setPassword("119");
    ResponseVO responseVO=adminController.addManager(userForm);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 

/** 
* 
* Method: getAllManagers() 
* 
*/ 
@Test
public void testGetAllManagers() throws Exception { 
//TODO: Test goes here...
    ResponseVO responseVO=adminController.getAllManagers();
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
}

    /**
     *
     * Method: deleteuser()
     *
     */
    @Test
    @Transactional
    public void testdeleteuser() throws Exception {
//TODO: Test goes here...
        ResponseVO responseVO=adminController.deleteuser("123@qq.com");
        System.out.println("Message:"+responseVO.getMessage());
        System.out.println("Success:"+responseVO.getSuccess());
        System.out.println("Content:"+responseVO.getContent());
        Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
    }


} 
