package com.calpis.interview.dubbo;

import com.calpis.interview.dubbo.spi.Robot;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/8 0:17
 */
@EnableDubbo(scanBasePackages = "com.calpis.interview.dubbo.service.impl")
@SpringBootApplication
public class DubboProviderApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Robot robot = ExtensionLoader.getExtensionLoader(Robot.class).getExtension("bumblebee");
    }
}
