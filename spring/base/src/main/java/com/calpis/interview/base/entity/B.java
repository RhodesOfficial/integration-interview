package com.calpis.interview.base.entity;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author Zhujialiang
 * @version V1.0
 * @Description
 * @Date 2021/2/19 14:40
 * @Copyright Copyright © 2020 深圳花儿绽放网络科技股份有限公司. All rights reserved.
 */
@Component
public class B implements InitializingBean {

    @Autowired
    public void setA(A a) {
        this.a = a;
    }

    private A a;

    @Override
    public String toString() {
        return "我是b";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(a);
    }
}
