package com.elb.udpStudy;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class udpServerDemo {
    public static void main(String[] args) throws Exception {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        //接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);//接收
        socket.receive(packet);//阻塞接收
        socket.close();

    }
}
