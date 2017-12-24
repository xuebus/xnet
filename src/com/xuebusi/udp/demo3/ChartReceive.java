package com.xuebusi.udp.demo3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 多线程聊天程序之接收端
 * Created by SYJ on 2017/12/24.
 */
public class ChartReceive implements Runnable {

    private DatagramSocket ds;

    public ChartReceive(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
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
