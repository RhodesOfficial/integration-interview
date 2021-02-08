package com.calpis.interview.dubbo.service.impl;

import com.calpis.interview.dubbo.service.HelloService;
import lombok.SneakyThrows;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/8 0:15
 */
@DubboService
public class HelloServiceImpl implements HelloService {

    @Value("${server.port}")
    private int serverPort;

    @SneakyThrows
    @Override
    public String sayHello(String name) {
//        TimeUnit.SECONDS.sleep(5);
        return "Hello! " + name + " serverPort: " + serverPort;
    }
}
