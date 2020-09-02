package com.magnus.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckCookie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookie = req.getCookies();
        if(cookie.length != 0 && null != cookie){
            for(int i = 0; i < cookie.length; i++){
                Cookie cook = cookie[i];
                String cookiename = cook.getName();
                if("user".equals(cookiename)) {
                    String cookieValue = cook.getValue();
                    System.out.println("CookieValue " + cookieValue);
                }
            }
        }
    }
}
