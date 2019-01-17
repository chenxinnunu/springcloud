package com.ruicheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chenxinnunu@gmail.com
 * @date 2019/1/16 17:04
 */
/**
 * 服务提供者
 * @ EnableDiscoveryClient 开启客户端发现
 * @ EnableFeignClients 开启Feign远程调用
 * @ EnableHystrix 启动hystrix的注解
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class CustomerServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServerApplication.class, args);
    }
}
