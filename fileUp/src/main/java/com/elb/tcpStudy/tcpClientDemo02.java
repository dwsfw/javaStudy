package com.elb.tcpStudy;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class tcpClientDemo02 {
    public static void main(String[] args) throws IOException {
        //创建一个socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File(""));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2=is.read(buffer2))!=-1){
            baos.write(buffer2,0,len2);
        }
        baos.close();
        is.close();
        fis.close();
        os.close();
        socket.close();
    }
}
