package com.xuebusi.tcp.demo1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP客户端，发送一条数据就关闭
 * Created by SYJ on 2017/12/24.
 */
public class TcpClient {

    public static void main(String[] args) {
        OutputStream out = null;
        try {
            //建立Socket连接，也就是建立数据发送和接收的通道，它包含一个输入流和一个输出流
            //输入流用于接收数据，输出流用于发送数据
            Socket s = new Socket("127.0.0.1", 10001);
            out = s.getOutputStream();
            out.write("你好".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
