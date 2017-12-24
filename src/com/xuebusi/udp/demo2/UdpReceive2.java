package com.xuebusi.udp.demo2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP接收端，持续接收消息，程序永不停止
 * Created by SYJ on 2017/12/24.
 */
public class UdpReceive2 {
    public static void main(String[] args) {
        //接收数据
        udpReceive();
    }

    public static void udpReceive() {
        DatagramSocket ds;
        try {
            //该句代码不要放到while循环里面，否则会抛出端口绑定异常(端口冲突)
            ds = new DatagramSocket(10000);
            while (true) {
                //聊天的话，1024足够用了(1k)，如果不够用可以使用new Byte[1024*64]，也就是取UDP协议允许的最大值64k。
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                //阻塞方法
                ds.receive(dp);
                String ip = dp.getAddress().getHostAddress();
                int port = dp.getPort();
                String data = new String(dp.getData(), 0, dp.getLength());
                System.out.println(ip + ":" + port + ", data:" + data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
