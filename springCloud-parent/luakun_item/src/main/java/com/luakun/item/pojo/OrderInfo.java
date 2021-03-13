package com.luakun.item.pojo;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: luakun
 * @Date: 2021/03/13/17:24
 * @Description:
 */
@Data
public class OrderInfo {
    private String username;
    private String orderId;
    private String itemId;
    private String itemName;
    private Long price;

}
