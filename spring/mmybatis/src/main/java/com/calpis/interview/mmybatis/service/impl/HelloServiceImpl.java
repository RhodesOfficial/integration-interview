package com.calpis.interview.mmybatis.service.impl;

import com.calpis.interview.mmybatis.mapper.HelloMapper;
import com.calpis.interview.mmybatis.mapper.HentaiMapper;
import com.calpis.interview.mmybatis.mapper.MuaMapper;
import com.calpis.interview.mmybatis.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/17 0:11
 */
@Service("HelloService")
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloMapper helloMapper;

    @Autowired
    private HentaiMapper hentaiMapper;

    @Autowired
    private MuaMapper muaMapper;

    @Override
    public void sayHello() {
        System.out.println(helloMapper.selectById());
        System.out.println(hentaiMapper.selectById());
        System.out.println(muaMapper.selectById());
    }
}
