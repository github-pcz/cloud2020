package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.omg.CORBA.INTERNAL;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import sun.nio.ch.DefaultSelectorProvider;

import java.util.concurrent.TimeUnit;

/**
 * @Author pcz
 * @Date 2021/2/22 16:27
 * @Version 1.0
 */
@Service
public class PaymentService {

    /**
     * 正常访问，肯定ok
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池：  "+Thread.currentThread().getName() + "  paymentInfo_OK,id   "+id+"\t" + "haha";
    }

    /**
     * 超时访问的方法
     *
     * 超时访问，演示降级
     * 故意制造两个异常，计算异常和超时异常，
     * 当前服务不可用力，做服务降级，兜底方案都是paymentInfo_TimeOutHandler
     *
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){
        // int age = 10/0;
        try {
            //暂停毫秒数
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：  "+Thread.currentThread().getName() + "  paymentInfo_Timeout,id   "+id+"\t" + "哈哈哈"+"耗时（秒）";
    }

    /**
     * 发生服务降级时使用的方法
     * @param id
     * @return
     */
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池：  "+Thread.currentThread().getName() + "  8001系统繁忙或者运行报错，请稍后再试,id   "+id+"\t" + "哭哭";
    }

    //=====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),   //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),    //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),    //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),   //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("******id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    /**
     * 服务熔断的处理方法
     */
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试，哭哭。。。。。 id：" + id;
    }



}
