package com.example.hotel.controller.order;

import com.example.hotel.bl.order.OrderService;
import com.example.hotel.vo.OrderVO;
import com.example.hotel.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: chenyizong
 * @Date: 2020-02-29
 */


@RestController()
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/addOrder")
    public ResponseVO reserveHotel(@RequestBody OrderVO orderVO){
        return orderService.addOrder(orderVO);
    }


    @GetMapping("/{orderId}/deleteOrder")
    public ResponseVO deleteOrder(@PathVariable int orderId){

        return  orderService.deleteOrder(orderId);
    }


    @GetMapping("/getAllOrders")
    public ResponseVO retrieveAllOrders(){
        return ResponseVO.buildSuccess(orderService.getAllOrders());
    }

    @GetMapping("/{userid}/getUserOrders")
    public  ResponseVO retrieveUserOrders(@PathVariable int userid){
        return ResponseVO.buildSuccess(orderService.getUserOrders(userid));
    }
    @GetMapping("/{orderid}/getOrder")
    public ResponseVO retrieveOrder(@PathVariable int orderid){
        return ResponseVO.buildSuccess(orderService.getOrderbyId(orderid));
    }

    @GetMapping("/{orderid}/annulOrder")
    public ResponseVO annulOrder(@PathVariable int orderid){
        return orderService.annulOrder(orderid);
    }

    @GetMapping("/{hotelId}/allOrders")
    public ResponseVO retrieveHotelOrders(@PathVariable Integer hotelId) {
        return ResponseVO.buildSuccess(orderService.getHotelOrders(hotelId));
    }


    @GetMapping("/{orderId}/{rate}/addOrderRate")
    public ResponseVO addOrderRate(@PathVariable int  orderId,@PathVariable int rate) {
        return ResponseVO.buildSuccess(orderService.addOrderRate( orderId,rate));
    }


    @GetMapping("/{orderId}/{comment}/addOrderComment")
    public ResponseVO addOrderComment(@PathVariable int  orderId,@PathVariable String comment) {
        return ResponseVO.buildSuccess(orderService.addOrderComment( orderId,comment));
    }
    @GetMapping("/{orderid}/{status}/changeStatus")
    public ResponseVO changeStatus(@PathVariable int orderid,@PathVariable String status){
        return orderService.changeStatus(orderid,status);
    }
    @GetMapping("/{orderId}/sethasaddcredit")
    public ResponseVO sethasaddcredit(@PathVariable int orderId){
        return orderService.sethasaddcredit(orderId,1);
    }
    @GetMapping("/{orderId}/gethasaddcredit")
    public ResponseVO gethasaddcredit(@PathVariable int orderId){
        return orderService.gethasaddcredit(orderId);
    }

}
