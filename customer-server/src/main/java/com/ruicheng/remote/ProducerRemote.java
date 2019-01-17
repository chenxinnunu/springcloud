package com.ruicheng.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chenxinnunu@gmail.com
 * @date 2019/1/16 17:26
 */
@Component
//在@FeignClient注解上添加fallback属性，指定熔断后调用的本地方法
@FeignClient(value = "producer-server", fallback = ProducerRemoteHystrix.class)
public interface ProducerRemote {
    @GetMapping("/")
    String get();
}
