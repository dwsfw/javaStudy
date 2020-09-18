package com.tlb.servlet;

import com.tlb.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class sessionDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        得到session
        HttpSession session = req.getSession();
//        给session存东西
        session.setAttribute("name",new Person(12,"信息"));
//        获取session的id
        String id = session.getId();
//        判断session是不是新建的
        if(session.isNew()){
            resp.getWriter().write("session创建成功，ID："+id);
        }else {
            resp.getWriter().write("session已经在服务器中存在了，ID:"+id);
        }
    }
}
