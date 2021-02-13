package com.calpis.interview.redis.service.impl;

import com.calpis.interview.redis.service.TimeService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/10 20:04
 */
@Service
public class TimeServiceImpl implements TimeService {

    private static long time;

    @PostConstruct
    public void init() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                time = System.currentTimeMillis();
            }
        }).start();
    }

    @Override
    public long getTime() {
        return time;
    }
}
