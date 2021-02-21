package com.calpis.interview.jdk.socket;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/21 14:27
 */
public class Client {

    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8080));
        // 发送请求
        ByteBuffer buffer = ByteBuffer.wrap("1234567890".getBytes());
        socketChannel.write(buffer);
        // 读取响应
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int num;
        if ((num = socketChannel.read(readBuffer)) > 0) {
            readBuffer.flip();
            byte[] re = new byte[num];
            readBuffer.get(re);
            String result = new String(re, StandardCharsets.UTF_8);
            System.out.println("返回值: " + result);
        }
        socketChannel.close();
    }
}
