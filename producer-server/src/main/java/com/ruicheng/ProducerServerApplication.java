package com.ruicheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务提供者
 * @ EnableDiscoveryClient 开启客户端发现
 * @ EnableFeignClients 开启Feign远程调用
 * @EnableHystrix 启动hystrix的注解
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProducerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerServerApplication.class, args);
    }

}

