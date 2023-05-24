package com.jkluv.one;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
    
        try {
            //1.创建Socket对象请求服务端的连接
            Socket socket = new Socket("127.0.0.1", 9999);
            //2.从socket对象中获取一个字节输出流
            OutputStream os = socket.getOutputStream();
            //3.把字节输出流包装成一个打印流
            PrintStream ps = new PrintStream(os);
            ps.println("服务端你好，这是客户端");
            ps.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
