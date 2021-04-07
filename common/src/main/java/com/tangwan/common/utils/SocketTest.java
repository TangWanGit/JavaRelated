/*
 * File Name:SocketTest is created on 2021/3/8 3:15 下午 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.common.utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author Zhao Xiaoli
 * @Description : SocketTest
 * @date 2021/3/8 3:15 下午
 * @since JDK 1.8
 */
public class SocketTest {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(8080));
        System.out.println(" NIO server started ... ");
        ss.configureBlocking(false);
        int idx = 0;
        while (true) {
            final SocketChannel socket = ss.accept();//阻塞方法
            new Thread(() -> {
                handle(socket);
            }, "线程[" + idx + "]").start();
        }
    }

    static void handle(SocketChannel socket) {
        try {
            socket.configureBlocking(false);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            socket.read(byteBuffer);
            byteBuffer.flip();
            System.out.println("请求：" + new String(byteBuffer.array()));
            String resp = "服务器响应";
            byteBuffer.get(resp.getBytes());
            socket.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
