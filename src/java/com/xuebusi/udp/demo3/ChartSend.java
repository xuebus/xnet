package com.xuebusi.udp.demo3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 多线程聊天程序之发送端
 * Created by SYJ on 2017/12/24.
 */
public class ChartSend implements Runnable {

    private DatagramSocket ds;

    public ChartSend(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = buff.readLine()) != null) {
                if ("886".equals(line)) break;
                byte[] buf = line.getBytes();
                DatagramPacket dp = new DatagramPacket(buf, 0, buf.length, InetAddress.getByName("127.0.0.1"), 9999);
                ds.send(dp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
