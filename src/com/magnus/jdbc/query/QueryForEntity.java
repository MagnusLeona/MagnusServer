package com.magnus.jdbc.query;

import com.magnus.jdbc.entity.User;
import com.magnus.jdbc.utils.Connector;

import java.lang.reflect.Field;
import java.sql.*;

public class QueryForEntity {
    public <T> T queryForMap(Class<T> clazz, String sql, Object ...args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Connector.getConnectionFromDriver();
            preparedStatement = connection.prepareStatement(sql);
            for(int i = 0; i < args.length; i ++){
                preparedStatement.setObject(i + 1, args[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columns = resultSetMetaData.getColumnCount();
            while(resultSet.next()){
                T instance = clazz.getDeclaredConstructor().newInstance();
                for(int i = 0; i < columns; i++){
                    String columnName = resultSetMetaData.getColumnName(i+1);
                    Object columnValue = resultSet.getObject(i+1);
                    Field field = instance.getClass().getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(instance,columnValue);
                }
                return instance;
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            Connector.closeConnetion(connection,preparedStatement);
        }
        return null;
    }
}
