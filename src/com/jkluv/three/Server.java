package com.jkluv.three;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：实现服务端可以接收多个客户端的Socket通信需求
 * 思路：服务端每接收到一个客户端的通信请求之后就交给一个独立的线程来处理客户端的数据交互需求
 */
public class Server {
    public static void main(String[] args) {
        try {
            //1.注册端口
            ServerSocket ss = new ServerSocket(9999);
            //2.定义一个死循环，负责不断地接收客户端的Socket连接请求
            while (true) {
                Socket socket = ss.accept();
                //3.创建一个独立的线程来处理与这个客户端的socket通信需求
                new ServerThreadReader(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}
