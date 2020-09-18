package com.tlb.filter;

import javax.servlet.*;
import java.io.IOException;

public class TestFiler implements Filter {
//    初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utd-8");
        servletResponse.setContentType("text/html;charset=UTF-8");

        filterChain.doFilter(servletRequest,servletResponse);//让我们的程序继续走，如果不写，请求到这里就被拦截停止

    }
//    销毁
    @Override
    public void destroy() {
        System.out.println("destory");
    }
}
