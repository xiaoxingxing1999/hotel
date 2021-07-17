package com.example.hotel.enums;

public enum BizRegion {
    XiDan("西单"),
    WanDa("万达"),
    XianLin("仙林"),
    GuLou("鼓楼");

    private String value;

    BizRegion(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
