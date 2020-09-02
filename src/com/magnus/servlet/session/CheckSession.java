package com.magnus.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String user = (String) httpSession.getAttribute("user");
        System.out.println("CheckSession " + user);
        //  将请求转发到静态资源，测试从静态资源到servlet请求是否会携带session值
        resp.sendRedirect("/MagnusServlet/static/pages/success.html");
    }
}
