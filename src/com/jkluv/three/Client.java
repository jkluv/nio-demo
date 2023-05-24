package com.jkluv.three;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        try {
            //1.请求与服务端连接
            Socket socket = new Socket("127.0.0.1", 9999);
            //2.得到一个打印流
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            //3.使用循环不断地给服务端发送消息
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("请说：");
                String msg = scanner.nextLine();
                printStream.println(msg);
                printStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
