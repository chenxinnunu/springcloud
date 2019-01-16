package com.ruicheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chenxinnunu@gmail.com
 * @date 2019/1/16 17:04
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class CustomerServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServerApplication.class, args);
    }
}
