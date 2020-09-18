package com.elb.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UpdReceiveDemo01 {
    public static void main(String[] args) throws Exception {

        //开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        //接收数据包
        byte[] buffer = new byte[1024];
        while(true) {
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);//接收
            //断开连接
            byte[] data = packet.getData();
            String s = new String(data, 0, data.length);
            if(s.equals("bye"))
                break;

            socket.receive(packet);//阻塞接收
        }
        socket.close();
    }
}
