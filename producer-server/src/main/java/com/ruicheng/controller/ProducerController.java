package com.ruicheng.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenxinnunu@gmail.com
 * @date 2019/1/16 16:18
 */
@RestController
public class ProducerController {
    @Value("${server.port}")
    private String port;
    @GetMapping("/")
    public String get() {
        return "Producer Server port: " + port;
    }
}
