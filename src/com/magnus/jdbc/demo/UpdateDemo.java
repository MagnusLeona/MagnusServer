package com.magnus.jdbc.demo;

import com.magnus.jdbc.utils.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = Connector.getConnectionFromDriver();
        String url = "update user set name=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(url);
        preparedStatement.setObject(1,"magnusLeona");
        preparedStatement.setObject(2,"0000000004");
        preparedStatement.execute();
    }
}
