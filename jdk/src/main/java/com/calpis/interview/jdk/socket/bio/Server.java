package com.calpis.interview.jdk.socket.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/21 14:33
 */
public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 监听 8080 端口进来的 TCP 链接
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        while (true) {
            // 这里会阻塞，直到有一个请求的连接进来
            SocketChannel socketChannel = serverSocketChannel.accept();
            // 开启一个新的线程来处理这个请求，然后在 while 循环中继续监听 8080 端口
            SocketHandler handler = new SocketHandler(socketChannel);
            new Thread(handler).start();
        }
    }

    static class SocketHandler implements Runnable {
        private final SocketChannel socketChannel;
        public SocketHandler(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }
        @Override
        public void run() {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            try {
                // 将请求数据读入 Buffer 中
                int num;
                while ((num = socketChannel.read(buffer)) > 0) {
                    // 读取 Buffer 内容之前先 flip 一下
                    buffer.flip();
                    // 提取 Buffer 中的数据
                    byte[] bytes = new byte[num];
                    buffer.get(bytes);
                    String re = new String(bytes, StandardCharsets.UTF_8);
                    System.out.println("收到请求：" + re);
                    // 回应客户端
                    ByteBuffer writeBuffer = ByteBuffer.wrap(("我已经收到你的请求，你的请求内容是：" + re).getBytes());
                    socketChannel.write(writeBuffer);
                    buffer.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
