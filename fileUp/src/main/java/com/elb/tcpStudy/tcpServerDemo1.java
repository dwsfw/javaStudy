package com.elb.tcpStudy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpServerDemo1 {
    public static void main(String[] args) {
        //有一个地址
        ServerSocket serverSocket=null;
        Socket accept=null;
        InputStream is=null;
        ByteArrayOutputStream byteArrayOutputStream=null;
        try {
            while (true) {
                serverSocket = new ServerSocket();
                //等待客户端连接过来
                accept = serverSocket.accept();
                //读取客户端消息
                is = accept.getInputStream();
            /*
            byte[] buffer = new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1){
                String msg=new String(buffer,0,len);
                System.out.println(msg);
                }
             */
                //管道流
                byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, len);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            if(byteArrayOutputStream!=null)
            {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is!=null)
            {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(accept!=null)
            {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket!=null)
            {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
