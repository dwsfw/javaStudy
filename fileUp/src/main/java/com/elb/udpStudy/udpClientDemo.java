package com.elb.udpStudy;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpClientDemo {
    public static void main(String[] args) throws Exception {
        //建立一个socket
        DatagramSocket socket = new DatagramSocket();
        //建个包
        String msg="你好！";
        //发给谁
        InetAddress localhost = InetAddress.getByName("127.0.0.1");
        int port=9090;
        //数据，数据长度，发给谁
        DatagramPacket packet = new DatagramPacket(msg.getBytes(),0, msg.getBytes().length, localhost, port);
        //发送
        socket.send(packet);
        socket.close();
    }
}
