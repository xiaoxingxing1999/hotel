package com.example.hotel.controller.coupon;

import com.example.hotel.controller.hotel.HotelController;
import com.example.hotel.vo.HotelTargetMoneyCouponVO;
import com.example.hotel.vo.HotelTargetRoomCouponVO;
import com.example.hotel.vo.ResponseVO;
import com.example.hotel.vo.TimeCouponVO;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/** 
* CouponController Tester. 
* 
* @author <Authors name> 
* @since <pre>6�� 22, 2020</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest

//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class CouponControllerTest {
    @Autowired
    private CouponController couponController;

    @Before
    public void before() throws Exception {
        System.out.println("开始测试-----------------");
    }

    @After
    public void after() throws Exception {
        System.out.println("测试结束-----------------");
    }

    /**
     * Method: addHotelTargetMoneyCoupon(@RequestBody HotelTargetMoneyCouponVO hotelTargetMoneyCouponVO)
     */
    @Test
    @Transactional
    public void testAddHotelTargetMoneyCoupon() throws Exception {
//TODO: Test goes here...
        HotelTargetMoneyCouponVO hotelTargetMoneyCouponVO = new HotelTargetMoneyCouponVO();
        hotelTargetMoneyCouponVO.setTargetMoney(500);
        hotelTargetMoneyCouponVO.setDiscountMoney(200);
        hotelTargetMoneyCouponVO.setHotelId(7);
        hotelTargetMoneyCouponVO.setName("满500-200");
        hotelTargetMoneyCouponVO.setType(3);
        hotelTargetMoneyCouponVO.setStatus(2);
        hotelTargetMoneyCouponVO.setDescription("满500-200");
        ResponseVO responseVO = couponController.addHotelTargetMoneyCoupon(hotelTargetMoneyCouponVO);
        System.out.println("Message:" + responseVO.getMessage());
        System.out.println("Success:" + responseVO.getSuccess());
        System.out.println("Content:" + responseVO.getContent());
        Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));


    }

    /**
     * Method: addHotelTargetTimeCoupon(@RequestBody TimeCouponVO timeCouponVO)
     */
    @Test
    @Transactional
    public void testAddHotelTargetTimeCoupon() throws Exception {
//TODO: Test goes here...
        TimeCouponVO timeCouponVO = new TimeCouponVO();
        timeCouponVO.setDiscount(0.2);
        timeCouponVO.setName("限时1");
        LocalDate localDate = LocalDate.of(2020, 6, 17);
        LocalTime localTime = LocalTime.of(11, 2, 11);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        timeCouponVO.setStartTime(localDateTime);
        LocalDate localDate2 = LocalDate.of(2020, 6, 18);
        LocalTime localTime2 = LocalTime.of(11, 2, 11);
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate2, localTime2);
        timeCouponVO.setStartTime(localDateTime2);
        timeCouponVO.setHotelId(7);
        timeCouponVO.setType(4);
        timeCouponVO.setStatus(1);
        timeCouponVO.setDescription("限时");
        ResponseVO responseVO = couponController.addHotelTargetTimeCoupon(timeCouponVO);
        System.out.println("Message:" + responseVO.getMessage());
        System.out.println("Success:" + responseVO.getSuccess());
        System.out.println("Content:" + responseVO.getContent());
        Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
    }

    /**
     * Method: addHotelTargetRoomCoupon(@RequestBody HotelTargetRoomCouponVO hotelTargetRoomCouponVO)
     */
    @Test
    @Transactional
    public void testAddHotelTargetRoomCoupon() throws Exception {
//TODO: Test goes here...
        HotelTargetRoomCouponVO hotelTargetRoomCouponVO = new HotelTargetRoomCouponVO();
        hotelTargetRoomCouponVO.setName("房间");
        hotelTargetRoomCouponVO.setDiscount(0.2);
        hotelTargetRoomCouponVO.setDescription("房间");
        hotelTargetRoomCouponVO.setStatus(1);
        hotelTargetRoomCouponVO.setType(2);
        ResponseVO responseVO = couponController.addHotelTargetRoomCoupon(hotelTargetRoomCouponVO);
        System.out.println("Message:" + responseVO.getMessage());
        System.out.println("Success:" + responseVO.getSuccess());
        System.out.println("Content:" + responseVO.getContent());
        Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));

    }

    /**
     * Method: getHotelAllCoupons(@RequestParam Integer hotelId)
     */
    @Test
    public void testGetHotelAllCoupons() throws Exception {
//TODO: Test goes here...
        ResponseVO responseVO = couponController.getHotelAllCoupons(7);
        System.out.println("Message:" + responseVO.getMessage());
        System.out.println("Success:" + responseVO.getSuccess());
        System.out.println("Content:" + responseVO.getContent());
        Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));

    }

    /**
     * Method: getOrderMatchCoupons(@RequestParam Integer userId, @RequestParam Integer hotelId, @RequestParam Double orderPrice, @RequestParam Integer roomNum, @RequestParam String checkIn, @RequestParam String checkOut, @RequestParam String createDate)
     */
    @Test
    public void testGetOrderMatchCoupons() throws Exception {
//TODO: Test goes here...
        ResponseVO responseVO = couponController.getOrderMatchCoupons(5, 5, 1120.0,
                3, "2020-06-17", "2020-06-19", "2020-06-18");
        System.out.println("Message:" + responseVO.getMessage());
        System.out.println("Success:" + responseVO.getSuccess());
        System.out.println("Content:" + responseVO.getContent());
        Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
    }

    /**
     * Method: deleteCoupon(@PathVariable String couponName)
     */
    @Test
    @Transactional
    public void testdeleteCoupon() throws Exception {
//TODO: Test goes here...
        ResponseVO responseVO = couponController.deleteCoupon("房间");
        System.out.println("Message:" + responseVO.getMessage());
        System.out.println("Success:" + responseVO.getSuccess());
        System.out.println("Content:" + responseVO.getContent());
        Assert.assertTrue(responseVO.getClass().getName().equals("com.example.hotel.vo.ResponseVO"));
    }
}
