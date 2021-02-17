package com.calpis.interview.dubbo;

import com.calpis.interview.dubbo.spi.Robot;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ServiceLoader;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/17 17:39
 */
@SpringBootTest
public class MyTest {

    @Test
    public void sayHello() {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        serviceLoader.forEach(Robot::sayHello);
    }

    public static void main(String[] args) {
//        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
//        serviceLoader.forEach(Robot::sayHello);
        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}
