package com.ruicheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * Turbin提供把多个hystrix.stream的内容聚合为一个数据源供Dashboard展示
 *
 * @author chenxin@chensanjin.xin
 * @date 2019/1/16 21:38
 */
@SpringBootApplication
//激活对Turbine的支持,使用了消息中间件收集监控数据，此注解不在适用
//@EnableTurbine
@EnableTurbineStream
@EnableDiscoveryClient
public class HystrixTurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication.class, args);
    }
}
