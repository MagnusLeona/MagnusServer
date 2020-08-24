package com.magnus.servlet.dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DispatcherDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("--------Start--------");
        String name = req.getParameter("user");
        ServletConfig servletConfig = this.getServletConfig();
        ServletContext servletContext = this.getServletContext();
        if("aaa".equals(name)){
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/welcome");
            requestDispatcher.forward(req,resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/welcome");
            requestDispatcher.include(req,resp);
        }
        printWriter.write("=======End=======");
    }
}
