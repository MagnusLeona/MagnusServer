package com.magnus.jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Connector {

    private static String url;
    private static String user;
    private static String password;
    private static String driverClass;

    // 静态代码块，在虚拟机初始化该类的时候就完成这个方法的加载，把数据库需要的配制信息传入类的静态变量中，可以避免反复加载该类
    static {
        Properties properties = new Properties();
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(inputStream);
            Connector.url = properties.getProperty("url");
            Connector.user = properties.getProperty("user");
            Connector.password = properties.getProperty("password");
            Connector.driverClass = properties.getProperty("driverClass");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //静态方法调用生成Connection
    public static Connection getConnectionFromDriver() throws SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        Properties properties = new Properties();
        properties.setProperty("user",user);
        properties.setProperty("password",password);
        Connection connection = driver.connect(url,properties);
        return connection;
    }

    public static Connection getConnectionFromDriverManager() throws ClassNotFoundException, SQLException {
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url,user,password);
        return connection;
    }

    public static void closeConnetion(Connection connection, PreparedStatement preparedStatement){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
