package com.magnus.servlet.counter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ClickCounter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post Request Got!");
        ServletContext servletContext = this.getServletConfig().getServletContext();
        Integer counter = null;
        counter = (Integer) servletContext.getAttribute("counterPost");
        synchronized (servletContext){
            if(counter == null){
                counter = 1;
            } else {
                counter ++;
            }
            servletContext.setAttribute("counterPost",counter);
        };
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(counter.toString());
        System.out.println("Post Request Handled!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get Request Got!");
        ServletContext servletContext = this.getServletConfig().getServletContext();
        Integer counter = null;
        counter = (Integer) servletContext.getAttribute("counterGet");
        synchronized (servletContext){
            if(counter == null){
                counter = 1;
            } else {
                counter ++;
            }
            servletContext.setAttribute("counterGet",counter);
        };
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(counter.toString());
        System.out.println("Get Request Handled!");
    }
}
