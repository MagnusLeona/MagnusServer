package com.magnus.servlet.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(urlPatterns = "/servletanno",loadOnStartup = 1)
public class ServletDemo extends HttpServlet {

    @PostConstruct
    public void postConstructMethod() {
        System.out.println("PostConstructMethod");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Init function");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("this is a test for servlet annotation");
    }

    @PreDestroy
    public void preDestroyMethod() {
        System.out.println("PreDestroyMethod");
    }
}
