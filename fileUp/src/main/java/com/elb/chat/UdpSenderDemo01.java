package com.elb.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpSenderDemo01 {
    public static void main(String[] args) throws Exception {
        //建立一个socket
        DatagramSocket socket = new DatagramSocket();
        //建个包
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String data = reader.readLine();
            byte[] datas = data.getBytes();

            //发给谁
            InetAddress localhost = InetAddress.getByName("127.0.0.1");
            int port = 9090;
            //数据，数据长度，发给谁
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, localhost, port);
            //发送
            socket.send(packet);
            if(data.equals("bye"))
                break;
        }
        socket.close();
    }
}
