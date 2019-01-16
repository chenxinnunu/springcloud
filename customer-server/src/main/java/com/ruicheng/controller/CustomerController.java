package com.ruicheng.controller;

import com.ruicheng.remote.ProducerRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenxinnunu@gmail.com
 * @date 2019/1/16 17:07
 */
@RestController
public class CustomerController {
    @Autowired
    private ProducerRemote producerRemote;
    @GetMapping("/")
    public String get() {
        return "Customer: " + producerRemote.get();
    }
}
