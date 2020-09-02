package com.magnus.listener;

import com.magnus.jdbc.query.QueryForString;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;

public class ServletContextListenerDemo implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context Initialized ... ");
        System.out.println("Start to Count ...");
        QueryForString queryForString = new QueryForString();
        String sql = "select * from webvisitcounter";
        queryForString.getOneString(sql);
        System.out.println(sql);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Context Destroyed");
    }
}
