package com.ruicheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenxin@chensanjin.xin
 * @date 2019/1/18 20:53
 */
@SpringBootApplication
@EnableDiscoveryClient
public class FileUploadServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileUploadServerApplication.class, args);

    }
}
