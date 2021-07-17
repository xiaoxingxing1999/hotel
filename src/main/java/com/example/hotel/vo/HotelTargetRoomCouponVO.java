package com.example.hotel.vo;

public class HotelTargetRoomCouponVO extends CouponVO {

    private Integer hotelId;

    private Double discount;

    @Override
    public String toString() {
        return "HotelTargetRoomCouponVO{" +
                "hotelId=" + hotelId +
                ", discount=" + discount +
                '}';
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
