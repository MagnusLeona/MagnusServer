package com.magnus.jdbc.query;

import com.magnus.jdbc.utils.DataSourceConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryForString {
    public Integer getOneString(String sql, Object ...args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Integer result = null;
        try {
            connection = DataSourceConnector.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for(int i = 0; i < args.length; i++){
                preparedStatement.setObject(i+1, args[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
