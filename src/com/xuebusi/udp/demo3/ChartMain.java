package com.xuebusi.udp.demo3;

import java.net.DatagramSocket;

/**
 * UDP聊天程序（多线程模拟聊天,发送端和接收端在同一个窗口）
 * Created by SYJ on 2017/12/24.
 */
public class ChartMain {
    public static void main(String[] args) {
        try {
            //发送端socket,如果未指定端口，系统将随机分配
            DatagramSocket sendSocket = new DatagramSocket();
            //接收端socket,监听9999端口
            DatagramSocket receiveSocket = new DatagramSocket(9999);

            // 启动发送端
            new Thread(new ChartSend(sendSocket)).start();
            // 启动接收端
            new Thread(new ChartReceive(receiveSocket)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
