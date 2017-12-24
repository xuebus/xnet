package com.xuebusi.tcp.demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP客户端，向服务端发送消息，并接收服务端的反馈
 * Created by SYJ on 2017/12/24.
 */
public class TcpClient {
    public static void main(String[] args) {
        Socket s = null;
        try {
            s = new Socket("127.0.0.1", 10002);
            OutputStream out = s.getOutputStream();
            out.write("你好".getBytes());

            //获取服务端反馈
            InputStream in = s.getInputStream();
            byte[] buf = new byte[1024];
            //read()方法是一个阻塞式方法
            int len = in.read(buf);
            String data = new String(buf, 0, len);
            System.out.println("服务端:" + data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
