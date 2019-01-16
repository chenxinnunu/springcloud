package com.ruicheng.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chenxinnunu@gmail.com
 * @date 2019/1/16 17:26
 */
@Component
@FeignClient(value = "producer-server", fallback = ProducerRemoteHystrix.class)
public interface ProducerRemote {
    @GetMapping("/")
    String get();
}
