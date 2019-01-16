package com.ruicheng.remote;

import org.springframework.stereotype.Component;

/**
 * @author chenxinnunu@gmail.com
 * @date 2019/1/16 17:27
 */
@Component
public class ProducerRemoteHystrix implements ProducerRemote{
    @Override
    public String get() {
        return "Producer Server 的服务调用失败";
    }
}
