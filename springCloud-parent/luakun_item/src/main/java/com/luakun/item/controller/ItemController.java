package com.luakun.item.controller;

import com.luakun.item.pojo.OrderInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: luakun
 * @Date: 2021/03/13/17:30
 * @Description:
 */

@RestController
@RequestMapping("/item")
public class ItemController {

    @GetMapping("{itemId}")
    public OrderInfo getInfo(@PathVariable(name = "itemId") String itemId){

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setItemId(itemId);
        orderInfo.setPrice(888L);
        orderInfo.setItemName("大华为P10");
        return orderInfo;

    }

}
