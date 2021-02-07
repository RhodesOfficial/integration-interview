package com.calpis.interview.dubbo;

import com.calpis.interview.dubbo.service.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/8 0:19
 */
@SpringBootTest
public class DubboConsumerTest {

    @DubboReference(url = "dubbo://127.0.0.1:20880")
    private HelloService helloService;

    @Test
    public void helloServiceTest() {
        System.out.println(helloService.sayHello("jack"));
    }
}
