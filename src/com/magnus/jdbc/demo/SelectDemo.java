package com.magnus.jdbc.demo;

import com.magnus.jdbc.utils.Connector;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = Connector.getConnectionFromDriver();
        String sql = "select * from user where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,"Lothric");
        // 使用ResultSet来接收查询结果
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
        int columns = resultSetMetaData.getColumnCount();
        while (resultSet.next()){
            for(int i = 0; i < columns; i++){
                System.out.println(resultSet.getObject(i + 1));
            }
        }
    }
}
