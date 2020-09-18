package com.tlb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//保存用户上次访问的时间
public class cookieDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        服务器，告诉你，你来的时间，把这个时间封装成为一个信件，你带下来，我就知道你来了

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
                if (cookie.getName().equals("lastLoginTime")) {
                    //获取cookie中的值
                    long l = Long.parseLong(cookie.getValue());
                    Date date = new Date(l);
                    writer.write(date.toLocaleString());
                }

            }

        }else {
            writer.write("这是你第一次来本站");
        }
        //服务器给客户端响应一个cookie
//        Cookie cookie = new Cookie("name", "qwe");
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
        cookie.setMaxAge(24*60*60);//有效期为一天
        resp.addCookie(cookie);

    }
}
