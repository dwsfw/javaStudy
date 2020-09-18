package com.elb.tcpStudy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpServerDemo02 {
    public static void main(String[] args) throws IOException {
        //创建服务
        ServerSocket serverSocket = new ServerSocket(9999);
        //监听客户端连接
        Socket socket = serverSocket.accept();//阻塞式监听，会一直等待
        //获取输入流
        InputStream is = socket.getInputStream();
        //文件输出
        FileOutputStream fos = new FileOutputStream(new File("receive"));
        byte[] buffer = new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        OutputStream os = socket.getOutputStream();
        os.write("我接收完毕了".getBytes());
        os.close();
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();

    }
}
