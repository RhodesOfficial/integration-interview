package com.calpis.interview.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/8 1:05
 */
public class ZkClient {

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        String connect = "127.0.0.1:2181";
        int timeout = 30000;
        ZooKeeper zooKeeper = new ZooKeeper(connect, timeout, watchedEvent -> {});
        System.out.println(zooKeeper.getState());
        while (true) {
            if (ZooKeeper.States.CONNECTING == zooKeeper.getState()) {
                Thread.sleep(1000);
            } else {
                break;
            }
        }
        System.out.println(zooKeeper.getState());
        List<String> children = zooKeeper.getChildren("/", true);
        System.out.println(children);
    }
}
