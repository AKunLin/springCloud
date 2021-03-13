package com.luakun.order.controller;

import com.luakun.order.pojo.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: luakun
 * @Date: 2021/03/13/17:50
 * @Description:
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{username}")
    public OrderInfo getOrderInfo(@PathVariable(name = "username") String username){
        String orderId = "OrderId:1122";
        System.out.println("该订单的订单编号为:" + orderId);
        String itemId = "sn:9527";
        System.out.println("该商品的编号为:" + itemId);

        OrderInfo orderInfo = restTemplate.getForObject("http://localhost:18081/item/" + itemId, OrderInfo.class);
        orderInfo.setUsername(username);
        orderInfo.setOrderId(orderId);
        return orderInfo;

    }


}
