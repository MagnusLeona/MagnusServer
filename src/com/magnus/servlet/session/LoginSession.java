package com.magnus.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginSession extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从客户端获取session，如果没有将创建一个
        HttpSession httpSession = req.getSession();
        String name = req.getParameter("name");
        System.out.println("LoginSession " + name);
        // 给session中设置值，这个值将保存在浏览器内存中，生命周期内每次访问服务端都会带上这个session值
        httpSession.setAttribute("user",name);
        resp.sendRedirect(resp.encodeRedirectURL("checksession"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
