package com.calpis.interview.dubbo.service.impl;

import com.calpis.interview.dubbo.service.HelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/8 0:15
 */
@Component
@DubboService
public class HelloServiceImpl implements HelloService {

    @Value("${server.port}")
    private int serverPort;

    @Override
    public String sayHello(String name) {
        return "Hello! " + name + " serverPort: " + serverPort;
    }
}
