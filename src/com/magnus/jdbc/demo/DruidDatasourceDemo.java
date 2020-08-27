package com.magnus.jdbc.demo;

import com.magnus.jdbc.utils.DataSourceConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDatasourceDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = DataSourceConnector.INSTANCE.getConnection();
        String sql = "insert into user(id,name,age,description) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,"0000000007");
        preparedStatement.setObject(2,"PhantomAssasin");
        preparedStatement.setObject(3,45);
        preparedStatement.setObject(4,"PA");
        preparedStatement.execute();
    }
}
