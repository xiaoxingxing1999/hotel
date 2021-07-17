package com.example.hotel.blImpl.order;

import com.example.hotel.bl.hotel.HotelService;
import com.example.hotel.bl.order.OrderService;
import com.example.hotel.bl.user.AccountService;
import com.example.hotel.data.order.OrderMapper;
import com.example.hotel.data.user.AccountMapper;
import com.example.hotel.enums.UserType;
import com.example.hotel.po.Hotel;
import com.example.hotel.po.Order;
import com.example.hotel.po.User;
import com.example.hotel.util.ServiceException;
import com.example.hotel.vo.OrderVO;
import com.example.hotel.vo.ResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @Author: chenyizong
 * @Date: 2020-03-04
 */
@Service
public class OrderServiceImpl implements OrderService {
    private final static String RESERVE_ERROR = "预订失败";
    private final static String ROOMNUM_LACK = "预订房间数量剩余不足";
    private final static String ANNUL_ERROR= "取消失败";
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    AccountMapper userMapper;
    @Autowired
    HotelService hotelService;
    @Autowired
    AccountService accountService;

    @Override
    public ResponseVO addOrder(OrderVO orderVO) {
        int reserveRoomNum = orderVO.getRoomNum();
        int curNum = hotelService.getRoomCurNum(orderVO.getHotelId(),orderVO.getRoomType());
        if(reserveRoomNum>curNum){
            return ResponseVO.buildFailure(ROOMNUM_LACK);
        }
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());
            String curdate = sf.format(date);
            orderVO.setCreateDate(curdate);
            orderVO.setOrderState("已预订");
            User user = accountService.getUserInfo(orderVO.getUserId());
            orderVO.setClientName(user.getUserName());
            orderVO.setPhoneNumber(user.getPhoneNumber());
            Order order = new Order();
            BeanUtils.copyProperties(orderVO,order);
            orderMapper.addOrder(order);
            hotelService.updateRoomInfo(orderVO.getHotelId(),orderVO.getRoomType(),orderVO.getRoomNum());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(RESERVE_ERROR);
        }
       return ResponseVO.buildSuccess(true);
    }

    @Override
    public ResponseVO deleteOrder(int orderId) {
        orderMapper.deleteOrder(orderId);

        return ResponseVO.buildSuccess(true);
    }





    @Override
    public List<Order> getAllOrders() {
        return orderMapper.getAllOrders();
    }

    @Override
    public List<Order> getUserOrders(int userid) {
        return orderMapper.getUserOrders(userid);
    }

    @Override
    public ResponseVO annulOrder(int orderid) {
        //取消订单逻辑的具体实现（注意可能有和别的业务类之间的交互）
        try{
            Order order=orderMapper.getOrderById(orderid);
            int roomNum=order.getRoomNum();
            hotelService.updateRoomInfo(order.getHotelId(),order.getRoomType(),-roomNum);
            orderMapper.annulOrder(orderid);
            LocalDate checkind=LocalDate.parse(orderMapper.getOrderById(orderid).getCheckInDate());
            LocalDate localDate=LocalDate.now();
            LocalDate tomorrow = localDate.plusDays(1);
            if(checkind.equals(tomorrow)){
                userMapper.addcredit(orderMapper.getOrderById(orderid).getUserId(),userMapper.getcreditbyid(orderMapper.getOrderById(orderid).getUserId())-orderMapper.getOrderById(orderid).getPrice()/2);
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(ANNUL_ERROR);
        }
        return ResponseVO.buildSuccess(true);
    }

    /**
     * @param hotelId
     * @return
     */
    @Override
    public List<Order> getHotelOrders(Integer hotelId) {
        List<Order> orders = getAllOrders();
        return orders.stream().filter(order -> order.getHotelId().equals(hotelId)).collect(Collectors.toList());
    }
    @Override
    public Order getOrderbyId(int orderid){
        return orderMapper.getOrderById(orderid);
    }

    @Override
    public ResponseVO addOrderRate(int orderId, int rate) {

        orderMapper.addOrderRate(orderId,  rate);
        return ResponseVO.buildSuccess(true);
    }
    @Override
    public ResponseVO addOrderComment(int orderId, String comment) {

        orderMapper.addOrderComment(orderId,  comment);
        return ResponseVO.buildSuccess(true);
    }
    @Override
    public ResponseVO changeStatus(int orderid, String status){
        if (status.equals("已评价")||status.equals("酒店撤销")){
            hotelService.updateRoomInfo(orderMapper.getOrderById(orderid).getHotelId(),orderMapper.getOrderById(orderid).getRoomType(),-orderMapper.getOrderById(orderid).getRoomNum());
        }
        LocalDate localDate=LocalDate.now();
        String localdatestring=localDate.toString().substring(0,4)+localDate.toString().substring(5,7)+localDate.toString().substring(8,10);
        String chechindatastring=orderMapper.getOrderById(orderid).getCheckInDate().substring(0,4)+orderMapper.getOrderById(orderid).getCheckInDate().substring(5,7)+orderMapper.getOrderById(orderid).getCheckInDate().substring(8,10);
        String chechoutdatastring=orderMapper.getOrderById(orderid).getCheckOutDate().substring(0,4)+orderMapper.getOrderById(orderid).getCheckOutDate().substring(5,7)+orderMapper.getOrderById(orderid).getCheckOutDate().substring(8,10);

        if((status.equals("酒店撤销"))&&(orderMapper.getOrderById(orderid).getOrderState().equals("已预订"))&&(Integer.valueOf(localdatestring)>=Integer.valueOf(chechindatastring))){
            userMapper.addcredit(orderMapper.getOrderById(orderid).getUserId(),userMapper.getcreditbyid(orderMapper.getOrderById(orderid).getUserId())-orderMapper.getOrderById(orderid).getPrice());
        }
        orderMapper.changeStatus(orderid,status);


        return ResponseVO.buildSuccess(true);
    }

    @Override
    public ResponseVO addcredit(int orderid) {
        Order myorder=orderMapper.getOrderById(orderid);
        double pastcredit=userMapper.getcreditbyid(myorder.getUserId());
        userMapper.addcredit(myorder.getUserId(),myorder.getPrice()+pastcredit);
        return ResponseVO.buildSuccess(true);
    }

    @Override
    public ResponseVO sethasaddcredit(int orderId,int has) {
        orderMapper.sethasaddcredit(orderId,has);
        return ResponseVO.buildSuccess(true);
    }

    @Override
    public ResponseVO gethasaddcredit(int orderId) {
        int i=orderMapper.gethasaddcredit(orderId);
        return ResponseVO.buildSuccess(i);
    }
}
