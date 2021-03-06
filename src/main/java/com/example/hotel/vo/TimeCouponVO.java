package com.example.hotel.vo;

import java.time.LocalDateTime;

public class TimeCouponVO extends CouponVO {
    private Integer hotelId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Override
    public String toString() {
        return "TimeCouponVO{" +
                "hotelId=" + hotelId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", discount=" + discount +
                ", targetMoney=" + targetMoney +
                '}';
    }
//自行决定是打折还是直接减金额 如果选择打折就把targetMoney变为负数 否则就把discount变为负数

    private double discount;
    private Integer targetMoney;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Integer getTargetMoney() {
        return targetMoney;
    }

    public void setTargetMoney(Integer targetMoney) {
        this.targetMoney = targetMoney;
    }
}
