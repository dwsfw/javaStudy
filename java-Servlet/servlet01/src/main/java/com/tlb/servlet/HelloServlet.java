package com.tlb.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ServletOutputStream outputStream = resp.getOutputStream();
//        this.getServletConfig()  servlet配置
//        this.getServletContext()  servlet上下文
//        this.getInitParameter()  初始化参数
//        PrintWriter writer = resp.getWriter();
//        writer.print("Hello");
//        System.out.println("hello");
        ServletContext servletContext = this.getServletContext();
        String username="儿童";
        servletContext.setAttribute("username",username);
    }
}
