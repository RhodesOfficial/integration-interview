package com.calpis.interview.base.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/3/3 23:05
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "hello world";
    }
}
