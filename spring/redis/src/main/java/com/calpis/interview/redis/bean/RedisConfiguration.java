package com.calpis.interview.redis.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

import java.util.List;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/10 20:24
 */
@Configuration
public class RedisConfiguration {

    @Bean
    public DefaultRedisScript<List> defaultRedisScript() {
        DefaultRedisScript<List> defaultRedisScript = new DefaultRedisScript<>();
        defaultRedisScript.setResultType(List.class);
        defaultRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("redis/unlock.lua")));
        return defaultRedisScript;
    }
}
