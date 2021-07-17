package com.example.hotel.vo;

public class CouponVO {
    private Integer id;
    private String description;
    private Integer status;

    @Override
    public String toString() {
        return "CouponVO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    private String name;
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
