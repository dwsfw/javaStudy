package com.tlb.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取下载文件的路径
        String realPath = this.getServletContext().getRealPath("src\\main\\resources\\1.jpg");
        System.out.println("下载文件的路径:"+realPath);
        //下载的文件是啥
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        //设置想办法让浏览器能够支持下载我们需要的东西
        resp.setHeader("Content-Disposition","attachment;filename="+fileName);
        //获取下载文件的输入流
        FileInputStream fileInputStream = new FileInputStream(realPath);
        //创建缓冲区
        int len=0;
        byte[] buffer=new byte[1024];
        //获取outputstream对象
        ServletOutputStream outputStream = resp.getOutputStream();
        //将FileOutputStream写入到buffer缓冲区，使用OutputStream将缓冲区中的数据输出到客户端；
        while ((len=fileInputStream.read(buffer))>0){
            outputStream.write(buffer,0,len);
        }
        fileInputStream.close();
        outputStream.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
