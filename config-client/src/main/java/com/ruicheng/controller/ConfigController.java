package com.ruicheng.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenxinnunu@gmail.com
 * @date 2019/1/18 10:58
*/
@RestController
//使用该注解的类,会在配置更改时得到特殊的处理
//配置更新后，springboot2.0发送post请求到http://localhost:8400/actuator/refresh之后更新的配置才会被应用到项目中
@RefreshScope
public class ConfigController {
    @Value("${management.endpoints.web.exposure.include}")
    private String hello;

    @GetMapping("/hello")
    public String getName() {
        return hello;
    }
}
