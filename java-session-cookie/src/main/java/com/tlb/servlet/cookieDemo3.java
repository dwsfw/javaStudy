package com.tlb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

public class cookieDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter writer = resp.getWriter();
        //Cookie，服务端从客户端获取
        Cookie[] cookies = req.getCookies();//cookie可能存在多个
        if(cookies!=null){
            //cookies存在
            writer.write("上次你访问的时间是：");

            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                //获取cookie的名字
                if (cookie.getName().equals("name")) {
                    //获取cookie中的值
                    writer.write(URLDecoder.decode(cookie.getValue(),"UTF-8"));
                }

            }

        }else {
            writer.write("这是你第一次来本站");
        }
        Cookie cookie = new Cookie("name", URLEncoder.encode("信息","utf-8"));
        resp.addCookie(cookie);
    }
}
