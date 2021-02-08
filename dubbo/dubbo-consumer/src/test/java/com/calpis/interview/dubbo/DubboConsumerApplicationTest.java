package com.calpis.interview.dubbo;

import com.calpis.interview.dubbo.service.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/8 0:19
 */
@SpringBootTest
public class DubboConsumerApplicationTest {

    /**
     * loadbalance
     * 1. random 随机权重
     * 2. consistenthash 一致性哈希 相同参数的请求总是发到同一提供者
     * 3. leastactive 最小活跃数负载均衡
     * 4. roundrobin 轮训
     *
     * cluster
     * 1. failover 失败自动切换
     * 2. failfast 快速失败
     * 3. failsafe 安全失败
     * 4. failback 失败自动恢复
     * 5. forking 并行调用多个服务器
     * 6. broadcast 广播调用
     */
    @DubboReference(loadbalance = "random", cluster = "forking")
    private HelloService helloService;

    @Test
    public void helloServiceTest() {
        while (true) {
            String res = helloService.sayHello("jack");
            System.out.println(res);
        }
    }
}
