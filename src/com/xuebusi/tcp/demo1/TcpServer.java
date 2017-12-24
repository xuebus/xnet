package com.xuebusi.tcp.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务端，接收一条数据就关闭服务端
 * Created by SYJ on 2017/12/24.
 */
public class TcpServer {

    public static void main(String[] args) {
        Socket s = null;
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(10001);
            s = ss.accept();
            String ip = s.getInetAddress().getHostAddress();
            System.out.println(ip + "......连接成功!");
            InputStream in = s.getInputStream();
            byte[] buf = new byte[1024];
            int len = in.read(buf);
            String data = new String(buf, 0, len);
            System.out.println("客户端:" + data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭客户端
                s.close();
                //关闭服务端(可选)
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
