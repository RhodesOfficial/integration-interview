package com.calpis.interview.kafka;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author Calpis
 * @Description kafka跑不起来,模拟一下
 * @Date 2021/2/15 23:39
 */
public class App {

    /**
     * topic
     */
    private static BlockingQueue<String> topic = new LinkedBlockingQueue<>();

    /**
     * 内存队列0
     */
    private static BlockingQueue<String> queue0 = new LinkedBlockingQueue<>();

    /**
     * 内存队列1
     */
    private static BlockingQueue<String> queue1 = new LinkedBlockingQueue<>();

    /**
     * 内存队列2
     */
    private static BlockingQueue<String> queue2 = new LinkedBlockingQueue<>();

    private static final String TEMPLATE = "%s exec %d";

    static class Producer {

        public void send(String log) throws InterruptedException {
            topic.put(log);
        }
    }

    static class Consumer {

        public String poll() throws InterruptedException {
            return topic.take();
        }
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                int userId = i % 3;
                for (int j = 0; j < 3; j++) {
                    // user0 0
                    // user0 1
                    // user0 2
                    // user1 0
                    // user1 1
                    // user1 2
                    try {
                        producer.send(String.format(TEMPLATE, "user" + userId, j));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "producer").start();


        // schedule
        new Thread(() -> {
            while (true) {
                String message = null;
                try {
                    message = consumer.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String userId = message.substring(4, 5);
                switch (userId) {
                    case "0":
                        queue0.offer(message);
                        break;
                    case "1":
                        queue1.offer(message);
                        break;
                    case "2":
                        queue2.offer(message);
                        break;
                    default:
                        throw new RuntimeException();
                }
            }
        }).start();

        Thread thread0 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println(queue0.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread0.start();

        Thread thread1 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println(queue1.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println(queue2.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
    }
}
