package com.xuebusi.udp.demo1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP发送端，发送一次程序就结束
 * Created by SYJ on 2017/12/24.
 */
public class UdpSend {
    public static void main(String[] args) {
        //UDP发送
        udpSend();
    }

    public static void udpSend() {
        //1.建立updsocket服务
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(20000);
            //2.封装数据
            byte[] buf = "测试udp协议发送数据".getBytes();
            DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 10000);
            //3.发送
            ds.send(dp);
            //4.关闭资源
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ds.close();
        }
    }
}
