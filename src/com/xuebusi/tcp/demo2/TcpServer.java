package com.xuebusi.tcp.demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务端,向客户端反馈消息
 * Created by SYJ on 2017/12/24.
 */
public class TcpServer {
    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket s = null;
        try {
            ss = new ServerSocket(10002);
            //accept()是一个阻塞式方法
            s = ss.accept();
            String ip = s.getInetAddress().getHostAddress();
            System.out.println(ip + "......连接成功!");

            InputStream in = s.getInputStream();
            byte[] buf = new byte[1024];
            //read()方法是一个阻塞式方法
            int len = in.read(buf);
            String data = new String(buf, 0, len);
            System.out.println("客户端:" +data);

            OutputStream out = s.getOutputStream();
            out.write("我不好".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
