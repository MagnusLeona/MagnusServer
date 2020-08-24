package com.magnus.servlet.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetOrPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is Post Action");
        PrintWriter out = resp.getWriter();
        out.write("You send a Post Action ....");
        // req.getParameter 获取post请求中的上送参数
        out.write("GetParameter:" + req.getParameter("userId"));
        out.write("PathInfo: " + req.getPathInfo());
        out.write("ServletPath: " + req.getServletPath());
        out.write("Protocol: " + req.getProtocol());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is Get Action");
        PrintWriter out = resp.getWriter();
        out.write("You send a Get Action ....");
        //req.getQueryString() 获取get请求中的上送参数
        out.write("QueryString: " + req.getQueryString());
        out.write("Method: " + req.getMethod());
        out.write("PathInfo: " + req.getPathInfo());
        out.write("ServletPath: " + req.getServletPath());
        out.write("Protocol: " + req.getProtocol());
    }
}
