package com.xuebusi.udp.demo2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP发送端，模拟键盘录入，持续发送消息
 * Created by SYJ on 2017/12/24.
 */
public class UdpSend2 {
    public static void main(String[] args) {
        //UDP发送
        udpSend();
    }

    public static void udpSend() {
        //1.建立socket服务
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(8888);
            //从键盘录入数据
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //2.封装数据包
            DatagramPacket dp;
            String line;
            while ((line = reader.readLine()) != null) {
                if ("886".equals(line)) break;
                byte[] buf = line.getBytes();
                dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 10000);
                ds.send(dp);//3.发送
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            ds.close();
        }
    }
}
