package com.luakun.order.controller;

import com.alibaba.cloud.nacos.discovery.NacosDiscoveryClient;
import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import com.luakun.order.pojo.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
    @Autowired
    private NacosServiceDiscovery nacosServiceDiscovery;


    @RequestMapping("/{username}")
    public OrderInfo getOrderInfo(@PathVariable(name = "username") String username){
        String orderId = "OrderId:1122";
        System.out.println("该订单的订单编号为:" + orderId);
        String itemId = "sn:9527";
        System.out.println("该商品的编号为:" + itemId);
        //OrderInfo orderInfo = restTemplate.getForObject("http://localhost:18081/item/" + itemId, OrderInfo.class);
        //+ 注入NacosServiceDiscovery 对象
        //+ 动态获取服务实例对应的ip地址和端口即可
        List<ServiceInstance> items = null;
        try {
            items = nacosServiceDiscovery.getInstances("item");
        } catch (NacosException e) {
            e.printStackTrace();
        }
        ServiceInstance serviceInstance = items.get(0);
        OrderInfo orderInfo = restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/item/"+itemId , OrderInfo.class);
        orderInfo.setUsername(username);
        orderInfo.setOrderId(orderId);
        return orderInfo;
    }
}
