package com.example.hotel.controller.user;

import com.example.hotel.controller.hotel.HotelController;
import com.example.hotel.enums.UserType;
import com.example.hotel.vo.ResponseVO;
import com.example.hotel.vo.UserForm;
import com.example.hotel.vo.UserInfoVO;
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
* AccountController Tester. 
* 
* @author <Authors name> 
* @since <pre>6�� 22, 2020</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest

//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class AccountControllerTest {
    @Autowired
    private AccountController accountController;
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
* Method: login(@RequestBody UserForm userForm) 
* 
*/ 
@Test
public void testLogin() throws Exception { 
//TODO: Test goes here...
    UserForm userForm=new UserForm();
    userForm.setPassword("123456");
    userForm.setEmail("123@qq.com");
    ResponseVO responseVO=accountController.login(userForm);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));

} 

/** 
* 
* Method: registerAccount(@RequestBody UserVO userVO) 
* 
*/ 
@Test
//@Transactional
public void testRegisterAccount() throws Exception { 
//TODO: Test goes here...
    UserVO userVO=new UserVO();
    userVO.setEmail("102@qq.com");
    userVO.setPassword("102");
    userVO.setUserName("102");
    userVO.setPhoneNumber("102");
    userVO.setUserType(UserType.Admin);
    ResponseVO responseVO=accountController.registerAccount(userVO);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));

} 

/** 
* 
* Method: getUserInfo(@PathVariable int id) 
* 
*/ 
@Test
public void testGetUserInfo() throws Exception { 
//TODO: Test goes here...
    ResponseVO responseVO=accountController.getUserInfo(28);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 

/** 
* 
* Method: updateInfo(@RequestBody UserInfoVO userInfoVO, @PathVariable int id) 
* 
*/ 
@Test
@Transactional
public void testUpdateInfo() throws Exception { 
//TODO: Test goes here...
    UserInfoVO userInfoVO=new UserInfoVO();
    userInfoVO.setPassword("124");
    userInfoVO.setPhoneNumber("124");
    userInfoVO.setUserName("124");
    ResponseVO responseVO=accountController.updateInfo(userInfoVO,28);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 

/** 
* 
* Method: getvip(@PathVariable int id) 
* 
*/ 
@Test
public void testGetvip() throws Exception { 
//TODO: Test goes here...
    ResponseVO responseVO=accountController.getvip(5);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());

    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 

/** 
* 
* Method: addcredit(@PathVariable int orderid) 
* 
*/ 
@Test
@Transactional
public void testAddcredit() throws Exception { 
//TODO: Test goes here...

    ResponseVO responseVO=accountController.addcredit(17);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 


} 
