package com.atguigu.springcloud;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName PaymentMain8001
 * @Description TODO
 * @Author pancz
 * @Date 2020/12/30 10:23
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8001 {

    //主启动
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
