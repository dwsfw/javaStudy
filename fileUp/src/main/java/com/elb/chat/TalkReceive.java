package com.elb.chat;

import java.io.BufferedReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TalkReceive implements Runnable {
    DatagramSocket socket=null;
    private String msgFrom;
    public TalkReceive(int port,String msgFrom) {
        this.port = port;
        this.msgFrom=msgFrom;
        try {
            socket=new DatagramSocket(port);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private int port;
    @Override
    public void run() {
        while(true) {
            try {
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                socket.receive(packet);
                byte[] data = packet.getData();
                String s = new String(data, 0, data.length);
                if(s.equals("bye"))
                    break;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
