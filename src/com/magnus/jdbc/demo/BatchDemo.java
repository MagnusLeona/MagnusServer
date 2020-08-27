package com.magnus.jdbc.demo;

import com.magnus.jdbc.utils.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = Connector.getConnectionFromDriver();
        String sql = "insert into testbatch(name) values(?)";
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for(int i = 1; i <= 10000; i++){
            preparedStatement.setObject(1,i);
            preparedStatement.addBatch();
            if(i%500 == 0){
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }
        connection.commit();
        //preparedStatement.executeBatch();
    }
}
