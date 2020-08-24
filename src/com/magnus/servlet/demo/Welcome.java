package com.magnus.servlet.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Welcome extends HttpServlet {
    private String greetings;

    @Override
    public void init() {
        this.greetings = this.getServletConfig().getInitParameter("greetings");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("user");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<html><head><title>Welcome</title></head><body>");
        out.write("<div>" + this.greetings + name + "</div>");
        out.write("</body></html>");
    }
}
