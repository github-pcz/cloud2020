package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * @ClassName PaymentMain8001
 * @Description TODO
 * @Author pancz
 * @Date 2020/12/30 10:23
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain8001 {

    //主启动
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }

}
