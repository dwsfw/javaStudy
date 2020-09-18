package com.elb.chat;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TalkSend implements Runnable {
    DatagramSocket socket=null;
    BufferedReader reader=null;
    private String fromIp;
    private  String toIp;
    private  int fromPort;
    private int toPort;

    public TalkSend(String toIp, int fromPort, int toPort) {
        this.toIp = toIp;
        this.fromPort = fromPort;
        this.toPort = toPort;
        try {
            socket=new DatagramSocket(fromPort);
            reader=new BufferedReader(new InputStreamReader(System.in));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                String data = reader.readLine();
                byte[] datas = data.getBytes();
                DatagramPacket packet = new DatagramPacket(datas, 0, data.length(), new InetSocketAddress(this.toIp, this.toPort));
                socket.send(packet);
                if (data.equals("bye"))
                    break;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
