package com.calpis.interview.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/17 22:56
 */
@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping("/")
    public String hello() {
        return "hello";
    }
}
