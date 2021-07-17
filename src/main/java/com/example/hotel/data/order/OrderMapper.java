package com.example.hotel.data.order;

import com.example.hotel.po.Order;
import com.example.hotel.vo.OrderVO;
import com.example.hotel.vo.ResponseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: chenyizong
 * @Date: 2020-03-04
 */
@Mapper
@Repository
public interface OrderMapper {

    int addOrder(Order order);

    void deleteOrder(int oderId);

    List<Order> getAllOrders();

    List<Order> getUserOrders(@Param("userid") int userid);

    int annulOrder(@Param("orderid") int orderid);

    Order getOrderById(@Param("orderid") int orderid);

    void addOrderRate(int orderId,  int rate);
    void addOrderComment(int orderId, String comment);
    int changeStatus(@Param("orderid") int orderid,@Param("status") String status);
    double getHotelRate(int hotelId);
    void sethasaddcredit(int orderId,int has);
    int gethasaddcredit(int orderId);
}
