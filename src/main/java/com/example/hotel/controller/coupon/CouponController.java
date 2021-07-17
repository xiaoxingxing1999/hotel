package com.example.hotel.controller.coupon;

import com.example.hotel.bl.coupon.CouponService;
import com.example.hotel.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/hotelTargetMoney")//添加coupon，调用逻辑层接口
    public ResponseVO addHotelTargetMoneyCoupon(@RequestBody HotelTargetMoneyCouponVO hotelTargetMoneyCouponVO) {

        CouponVO couponVO = couponService.addHotelTargetMoneyCoupon(hotelTargetMoneyCouponVO);

        return ResponseVO.buildSuccess(couponVO);
    }

    @PostMapping("/hotelTargetTime")//添加coupon，调用逻辑层接口
    public ResponseVO addHotelTargetTimeCoupon(@RequestBody TimeCouponVO timeCouponVO) {

        CouponVO couponVO = couponService.addHotelTargetTimeCoupon(timeCouponVO);

        return ResponseVO.buildSuccess(couponVO);
    }

    @PostMapping("/hotelTargetRoom")//添加coupon，调用逻辑层接口
    public ResponseVO addHotelTargetRoomCoupon(@RequestBody HotelTargetRoomCouponVO hotelTargetRoomCouponVO) {

        CouponVO couponVO = couponService.addHotelTargetRoomCoupon(hotelTargetRoomCouponVO);

        return ResponseVO.buildSuccess(couponVO);
    }
    @GetMapping("/{couponName}/deleteCoupon")
    public ResponseVO deleteCoupon(@PathVariable String couponName) {
        couponService.deleteCoupon(couponName);
        return ResponseVO.buildSuccess(true);
    }

    @GetMapping("/hotelAllCoupons")
    public ResponseVO getHotelAllCoupons(@RequestParam Integer hotelId) {
        return ResponseVO.buildSuccess(couponService.getHotelAllCoupon(hotelId));
    }

    @GetMapping("/orderMatchCoupons")
    public ResponseVO getOrderMatchCoupons(@RequestParam Integer userId,
                                           @RequestParam Integer hotelId,
                                           @RequestParam Double orderPrice,
                                           @RequestParam Integer roomNum,
                                           @RequestParam String checkIn,
                                           @RequestParam String checkOut,
                                           @RequestParam String createDate) {
        OrderVO requestOrderVO = new OrderVO();
        requestOrderVO.setUserId(userId);
        requestOrderVO.setHotelId(hotelId);
        requestOrderVO.setPrice(orderPrice);
        requestOrderVO.setRoomNum(roomNum);
        requestOrderVO.setCheckInDate(checkIn);
        requestOrderVO.setCheckOutDate(checkOut);
        requestOrderVO.setCreateDate(createDate);
        return ResponseVO.buildSuccess(couponService.getMatchOrderCoupon(requestOrderVO));
    }


}
