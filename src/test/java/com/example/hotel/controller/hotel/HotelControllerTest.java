package com.example.hotel.controller.hotel;

import com.example.hotel.bl.hotel.HotelService;
import com.example.hotel.enums.RoomType;
import com.example.hotel.po.HotelRoom;
import com.example.hotel.vo.HotelVO;
import com.example.hotel.vo.ResponseVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;

/** 
* HotelController Tester. 
* 
* @author <Authors name> 
* @since <pre>6�� 21, 2020</pre> 
* @version 1.0 
*/

@RunWith(SpringRunner.class)
@SpringBootTest

//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class HotelControllerTest {

@Autowired
private HotelController hotelController;

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
* Method: createHotel(@RequestBody HotelVO hotelVO) 
* 
*/

@Test
@Transactional
public void testCreateHotel() throws Exception {
//TODO: Test goes here...
    HotelVO hotelVO1 = new HotelVO();
    hotelVO1.setName("Adam");
    hotelVO1.setAddress("didian");
    hotelVO1.setDetail("11");
    hotelVO1.setDescription("11");
    hotelVO1.setHotelStar("Three");
    hotelVO1.setPhoneNum("11");
    hotelVO1.setManagerId(6);
    hotelVO1.setBizRegion("XiDan");
    hotelVO1.setRate(1.1);
    ResponseVO responseVO=hotelController.createHotel(hotelVO1);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 

/** 
* 
* Method: deleteHotel(@PathVariable Integer hotelId) 
* 
*/ 
@Test
@Transactional
public void testDeleteHotel() throws Exception { 
//TODO: Test goes here...
    ResponseVO responseVO=hotelController.deleteHotel(6);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 

/** 
* 
* Method: retrieveAllHotels() 
* 
*/ 
@Test
public void testRetrieveAllHotels() throws Exception { 
//TODO: Test goes here...
    ResponseVO responseVO=hotelController.retrieveAllHotels();
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
   Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));

} 

/** 
* 
* Method: addRoomInfo(@RequestBody HotelRoom hotelRoom) 
* 
*/ 
@Test
@Transactional
public void testAddRoomInfo() throws Exception { 
//TODO: Test goes here...
    HotelRoom hotelRoom=new HotelRoom();
 hotelRoom.setHotelId(7);
 hotelRoom.setCurNum(20);
 hotelRoom.setRoomType(RoomType.Family);
 hotelRoom.setTotal(20);
 hotelRoom.setPrice(100);
    ResponseVO responseVO=hotelController.addRoomInfo(hotelRoom);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 

/** 
* 
* Method: retrieveHotelDetail(@PathVariable Integer hotelId) 
* 
*/ 
@Test
public void testRetrieveHotelDetail() throws Exception { 
//TODO: Test goes here...
    ResponseVO responseVO=hotelController.retrieveHotelDetail(2);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 

/** 
* 
* Method: getHotelRate(@PathVariable int orderId) 
* 
*/ 
@Test
public void testGetHotelRate() throws Exception { 
//TODO: Test goes here...
    ResponseVO responseVO=hotelController.getHotelRate(17);
    System.out.println("Message:"+responseVO.getMessage());
    System.out.println("Success:"+responseVO.getSuccess());
    System.out.println("Content:"+responseVO.getContent());
    Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
} 


} 
