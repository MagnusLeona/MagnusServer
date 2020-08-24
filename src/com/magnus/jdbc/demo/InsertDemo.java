package com.magnus.jdbc.demo;

import com.magnus.jdbc.utils.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = Connector.getConnectionFromDriver();
        String sql = "insert into user(id,name,age,description) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,"0000000004");
        preparedStatement.setObject(2,"leona");
        preparedStatement.setObject(3,"25");
        preparedStatement.setObject(4,"its a discription");
        preparedStatement.execute();
    }
}
