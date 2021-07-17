package com.example.hotel.bl.order;

import com.example.hotel.po.Order;
import com.example.hotel.vo.OrderVO;
import com.example.hotel.vo.ResponseVO;

import java.util.List;

/**
 * @Author: chenyizong
 * @Date: 2020-03-04
 */
public interface OrderService {

    /**
     * 预订酒店
     * @param orderVO
     * @return
     */
    ResponseVO addOrder(OrderVO orderVO);
    /**
     * 删除订单
     * @param orderId
     * @return
     */
    ResponseVO deleteOrder(int orderId);
    /**
     * 获得所有订单信息
     * @return
     */
    List<Order> getAllOrders();

    /**
     * 获得指定用户的所有订单信息
     * @param userid
     * @return
     */
    List<Order> getUserOrders(int userid);

    /**
     * 撤销订单
     * @param orderid
     * @return
     */
    ResponseVO annulOrder(int orderid);

    /**
     * 查看酒店的所有订单
     * @param hotelId
     * @return
     */
    List<Order> getHotelOrders(Integer hotelId);
    /**
     * 添加订单rate
     * @param orderId,rate
     * @return
     */
    ResponseVO addOrderRate( int  orderId,int rate);

    /**
     * 添加订单评价
     * @param orderId,comment
     * @return
     */
    ResponseVO addOrderComment( int orderId,String comment);/**
     * 根据orderid获取对应的order记录
     * @param orderid
     * @return
     */
    Order getOrderbyId(int orderid);
    /**
     * 管理订单状态
     * @param orderid
     * @param status
     * @return
     */
    ResponseVO changeStatus(int orderid,String status);
    /**
     * 提高信用
     * @param orderid
     * @return
     */
    ResponseVO addcredit(int orderid);
    /**
     * 设置已经提高信用
     * @param orderId,has
     * @return
     */
    ResponseVO sethasaddcredit(int orderId,int has);
    /**
     * 获得已经提高信用
     * @param orderId
     * @return
     */
    ResponseVO gethasaddcredit(int orderId);
}
