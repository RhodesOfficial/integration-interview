package com.calpis.interview.base.service.impl;

import com.calpis.interview.base.service.AnotherService;
import com.calpis.interview.base.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/28 21:09
 */
@Service
public class AnotherServiceImpl implements AnotherService {

    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
