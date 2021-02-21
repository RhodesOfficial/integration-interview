package com.calpis.interview.jdk.socket.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/21 15:23
 */
public class AIOClient {

    public static void main(String[] args) throws Exception {
            AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
            // 来个 Future 形式的
            Future<?> future = client.connect(new InetSocketAddress("localhost", 8080));
            // 阻塞一下，等待连接成功
            future.get();

            Attachment att = new Attachment();
            att.setClient(client);
            att.setReadMode(false);
            att.setBuffer(ByteBuffer.allocate(2048));
            byte[] data = "I am obot!".getBytes();
            att.getBuffer().put(data);
            att.getBuffer().flip();

            // 异步发送数据到服务端
            client.write(att.getBuffer(), att, new ClientChannelHandler());

            // 这里休息一下再退出，给出足够的时间处理数据
            Thread.sleep(2000);
        }
}
