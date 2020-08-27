package com.magnus.jdbc.demo;

import com.magnus.jdbc.utils.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDemo {
//    JDBC事务处理
    public static void main(String[] args) throws SQLException {
        Connection connection = Connector.getConnectionFromDriver();
        connection.setAutoCommit(false);
        String sql = "insert into user(id,name,age,description) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,"0000000005");
        preparedStatement.setObject(2,"Chenht");
        preparedStatement.setObject(3,24);
        preparedStatement.setObject(4,"I am a boy");
        preparedStatement.execute();

        preparedStatement.setObject(1,"0000000006");
        preparedStatement.setObject(2,"BladeMaster");
        preparedStatement.setObject(3,34);
        preparedStatement.setObject(4,"Juggernaunt");
        preparedStatement.execute();

        connection.commit();

        Connector.closeConnetion(connection,preparedStatement);
    }
}
