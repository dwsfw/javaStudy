package com.tlb.listen;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCountListener implements HttpSessionListener {
//    创建session监听
//    创建session就会触发一次事件
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");
        if(onlineCount==null){
            onlineCount=new Integer(1);
        }else {
            int count=onlineCount.intValue();
            onlineCount=new Integer(count+1);
        }
        servletContext.setAttribute("OnlineCount",onlineCount);

    }
//    销毁session监听
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");
        if(onlineCount==null){
            onlineCount=new Integer(0);
        }else {
            int count=onlineCount.intValue();
            onlineCount=new Integer(count-1);
        }
        servletContext.setAttribute("OnlineCount",onlineCount);
    }
}
