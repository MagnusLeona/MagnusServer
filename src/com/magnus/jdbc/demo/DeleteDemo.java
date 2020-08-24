package com.magnus.jdbc.demo;

import com.magnus.jdbc.utils.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = Connector.getConnectionFromDriver();
        String sql = "delete from user where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,"0000000004");
        preparedStatement.execute();
    }
}
