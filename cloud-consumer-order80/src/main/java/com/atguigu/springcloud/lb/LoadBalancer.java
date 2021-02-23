package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author pcz
 * @Date 2021/1/19 17:06
 * @Version 1.0
 */
public interface LoadBalancer {


    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
