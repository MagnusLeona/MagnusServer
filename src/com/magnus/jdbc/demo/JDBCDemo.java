package com.magnus.jdbc.demo;

import com.magnus.jdbc.utils.Connector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //新建一个Diver对象
        Driver driver = new com.mysql.cj.jdbc.Driver();
        //创建properties对象用来存放登录mysql数据
        Properties properties = new Properties();
        String url = "jdbc:mysql://localhost:3306/magnus?serverTimezone=UTC";
        properties.setProperty("user", "root");
        properties.setProperty("password", "leonardo970915");
        //通过driver连接数据库
        Connection connection = driver.connect(url, properties);
        System.out.println(connection);

        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver1 = (Driver) clazz.getDeclaredConstructor().newInstance();
        DriverManager.registerDriver(driver1);
        Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/magnus?serverTimezone=UTC", "root", "leonardo970915");
        System.out.println(connection1);

        Connection connection2 = Connector.getConnectionFromDriver();
        System.out.println(connection2);

        Connection connection3 = Connector.getConnectionFromDriverManager();
        System.out.println(connection3);
    }
}
