package com.calpis.interview.netty.example.echo;

import io.netty.util.concurrent.*;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/22 1:31
 */
@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) {
        // 构造线程池
        EventExecutor executor = new DefaultEventExecutor();
        // 创建 DefaultPromise 实例
        Promise promise = new DefaultPromise(executor);
        // 下面给这个 promise 添加两个 listener
        promise.addListener(new GenericFutureListener<Future<Integer>>() {
            @Override
            public void operationComplete(Future future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("任务结束，结果：" + future.get());
                } else {
                    System.out.println("任务失败，异常：" + future.cause());
                }
            }
        }).addListener(new GenericFutureListener<Future<Integer>>() {
            @Override
            public void operationComplete(Future future) throws Exception {
                System.out.println("任务结束，balabala...");
            }
        });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ignored) {}
                promise.setFailure(new RuntimeException());
            }
        });

        try {
            promise.await();
        } catch (InterruptedException ignored) {}
    }
}
