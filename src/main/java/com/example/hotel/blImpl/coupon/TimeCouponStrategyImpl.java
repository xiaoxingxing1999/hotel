package com.example.hotel.blImpl.coupon;

import com.example.hotel.bl.coupon.CouponMatchStrategy;
import com.example.hotel.po.Coupon;
import com.example.hotel.vo.OrderVO;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class TimeCouponStrategyImpl implements CouponMatchStrategy {


    /**
     * 判断某个订单是否满足某种限时优惠策略
     * @param orderVO
     * @return
     */
    @Override
    public boolean isMatch(OrderVO orderVO, Coupon coupon) {
        if(coupon.getCouponType()==4){
            try{
            LocalDateTime start=coupon.getStartTime();
            LocalDateTime end=coupon.getEndTime();
            LocalDateTime date =LocalDateTime.parse(orderVO.getCreateDate());
            return start.isBefore(date) && end.isAfter(date);
            } catch (Exception e) {
                System.out.println("error occurred when parsing creating date");
                return false;
            }
        }
        return false;
    }
}
