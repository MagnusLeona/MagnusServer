package com.magnus.servlet.demo;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println(servletConfig.toString());
        System.out.println("GetServletContext: " + servletConfig.getServletContext());
        System.out.println("GetServletName: " + servletConfig.getServletName());
        System.out.println("GetInitParams: " + servletConfig.getInitParameterNames());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter out = servletResponse.getWriter();
        out.write("Hi,Magnus");
        servletResponse.getWriter().write("HelloWorld");
        System.out.println("HelloWorld");
        out.close();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
