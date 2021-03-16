package com.luakun.item.controller;

import com.luakun.item.pojo.OrderInfo;
import org.springframework.web.bind.annotation.*;

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
    public OrderInfo getInfo(@PathVariable(name = "itemId") String itemId, @RequestHeader(value = "name" ) String value){
        //获取头信息 网关
        System.out.println("头信息:" +value);
        System.out.println("是我啊 我是 1 号 我先开始啦~~~~");
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setItemId(itemId);
        orderInfo.setPrice(888L);
        orderInfo.setItemName("大华为P10");
        return orderInfo;

    }

}
