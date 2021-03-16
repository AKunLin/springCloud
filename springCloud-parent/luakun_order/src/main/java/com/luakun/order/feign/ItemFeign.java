package com.luakun.order.feign;

import com.luakun.order.pojo.OrderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: luakun
 * @Date: 2021/03/16/17:36
 * @Description:
 */
@FeignClient(name = "item" , path = "/item")
public interface ItemFeign {


    @GetMapping("/item/{itemId}")
    public OrderInfo getOrderInfo(@PathVariable(name = "itemId") String itemId);
}
