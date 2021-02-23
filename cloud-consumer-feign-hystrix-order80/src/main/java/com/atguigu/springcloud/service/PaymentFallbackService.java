package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author pcz
 * @Date 2021/2/23 14:53
 * @Version 1.0
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_OK,  哈哈";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_TimeOut，   哭哭";
    }
}
