package com.calpis.interview.dubbo.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/17 17:36
 */
@SPI
public interface Robot {

    void sayHello();
}
