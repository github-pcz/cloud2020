package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName PaymentMain8002
 * @Description TODO
 * @Author pancz
 * @Date 2020/12/30 10:23
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002 {

    //主启动
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }
}
