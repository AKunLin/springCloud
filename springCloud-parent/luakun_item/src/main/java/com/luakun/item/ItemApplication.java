package com.luakun.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: luakun
 * @Date: 2021/03/13/17:22
 * @Description:
 */

@SpringBootApplication
@EnableDiscoveryClient //开启nacos服务注册
public class ItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemApplication.class,args);
    }
}
