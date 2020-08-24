package com.magnus.servlet.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckAuth extends HttpServlet {
    private String servletContext;

    @Override
    public void init() {
        this.servletContext = this.getServletContext().getServletContextName();
        System.out.println(this.servletContext);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getRequestURI());
        //获取项目的路径context
        System.out.println(req.getContextPath());
        System.out.println(req.getServerName());
        System.out.println(req.getServletPath());
        String name = req.getParameter("userId");
        String password = req.getParameter("password");
        if(name.equals("Magnus") && password.equals("leonardo")){
            resp.sendRedirect("/MagnusServlet/static/pages/success.html");
        } else {
            PrintWriter out = resp.getWriter();
            out.write("账户信息有误！");
            out.close();
        }
    }
}
