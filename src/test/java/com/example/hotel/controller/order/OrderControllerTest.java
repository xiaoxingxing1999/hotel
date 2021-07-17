package com.example.hotel.controller.order;

import com.example.hotel.controller.coupon.CouponController;
import com.example.hotel.enums.RoomType;
import com.example.hotel.vo.OrderVO;
import com.example.hotel.vo.ResponseVO;
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
* OrderController Tester. 
* 
* @author <Authors name> 
* @since <pre>6�� 22, 2020</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest

//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class OrderControllerTest {
    @Autowired
    private OrderController orderController;

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
* Method: reserveHotel(@RequestBody OrderVO orderVO) 
* 
*/ 
@Test
@Transactional
public void testReserveHotel() throws Exception { 
//TODO: Test goes here...
    OrderVO orderVO=new OrderVO();
    orderVO.setUserId(5);
    orderVO.setHotelId(7);
    orderVO.setHotelName("4K酒店");
    orderVO.setClientName("xi");
    orderVO.setPhoneNumber("11");
    orderVO.setCheckInDate("2020-06-14");
    orderVO.setCheckOutDate("2020-06-17");
    orderVO.setPrice(1000.0);
    orderVO.setRoomNum(1);
    orderVO.setRoomType("DoubleBed");
    orderVO.setHaveChild(false);
    orderVO.setPeopleNum(2);
    ResponseVO responseVO=orderController.reserveHotel(orderVO);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));

} 

/** 
* 
* Method: deleteOrder(@PathVariable int orderId) 
* 
*/ 
@Test
@Transactional
public void testDeleteOrder() throws Exception { 
//TODO: Test goes here...
    ResponseVO responseVO=orderController.deleteOrder(18);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 

/** 
* 
* Method: retrieveAllOrders() 
* 
*/ 
@Test
@Transactional
public void testRetrieveAllOrders() throws Exception { 
//TODO: Test goes here...
    ResponseVO responseVO=orderController.retrieveAllOrders();
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 

/** 
* 
* Method: retrieveUserOrders(@PathVariable int userid) 
* 
*/ 
@Test
public void testRetrieveUserOrders() throws Exception { 
//TODO: Test goes here...
    ResponseVO responseVO=orderController.retrieveUserOrders(8);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 

/** 
* 
* Method: retrieveOrder(@PathVariable int orderid) 
* 
*/ 
@Test
public void testRetrieveOrder() throws Exception { 
//TODO: Test goes here...
    ResponseVO responseVO=orderController.retrieveOrder(17);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 

/** 
* 
* Method: annulOrder(@PathVariable int orderid) 
* 
*/ 
@Test
@Transactional
public void testAnnulOrder() throws Exception { 
//TODO: Test goes here...
    ResponseVO responseVO=orderController.annulOrder(17);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 

/** 
* 
* Method: retrieveHotelOrders(@PathVariable Integer hotelId) 
* 
*/ 
@Test
public void testRetrieveHotelOrders() throws Exception { 
//TODO: Test goes here...
    ResponseVO responseVO=orderController.retrieveHotelOrders(7);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 

/** 
* 
* Method: addOrderRate(@PathVariable int  orderId, @PathVariable int rate) 
* 
*/ 
@Test
@Transactional
public void testAddOrderRate() throws Exception { 
//TODO: Test goes here...
    ResponseVO responseVO=orderController.addOrderRate(17,4);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 

/** 
* 
* Method: addOrderComment(@PathVariable int  orderId, @PathVariable String comment) 
* 
*/ 
@Test
@Transactional
public void testAddOrderComment() throws Exception { 
//TODO: Test goes here...
    ResponseVO responseVO=orderController.addOrderComment(17,"kkk");
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 

/** 
* 
* Method: changeStatus(@PathVariable int orderid, @PathVariable String status) 
* 
*/ 
@Test
@Transactional
public void testChangeStatus() throws Exception { 
//TODO: Test goes here...
    ResponseVO responseVO=orderController.changeStatus(49,"酒店撤销");
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
}

    /**
     *
     * Method: sethasaddcredit(@PathVariable int orderid)
     *
     */
    @Test
    @Transactional
    public void testSethasaddcredit() throws Exception {
//TODO: Test goes here...
        ResponseVO responseVO=orderController.sethasaddcredit(17);
        System.out.println("Message:"+responseVO.getMessage());
        System.out.println("Success:"+responseVO.getSuccess());
        System.out.println("Content:"+responseVO.getContent());
        Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
    }

    /**
     *
     * Method: gethasaddcredit(@PathVariable int orderid)
     *
     */
    @Test
    public void testGethasaddcredit() throws Exception {
//TODO: Test goes here...
        ResponseVO responseVO=orderController.gethasaddcredit(17);
        System.out.println("Message:"+responseVO.getMessage());
        System.out.println("Success:"+responseVO.getSuccess());
        System.out.println("Content:"+responseVO.getContent());
        Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
    }


} 
