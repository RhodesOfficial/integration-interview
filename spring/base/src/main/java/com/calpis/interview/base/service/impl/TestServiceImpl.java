package com.calpis.interview.base.service.impl;

import com.calpis.interview.base.App;
import com.calpis.interview.base.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zhujialiang
 * @version V1.0
 * @Description
 * @Date 2021/2/19 17:59
 * @Copyright Copyright © 2020 深圳花儿绽放网络科技股份有限公司. All rights reserved.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private App app;

    @Override
    public void hello() {
        app.hello();
    }
}
