package com.magnus.jdbc.demo;

import com.magnus.jdbc.entity.User;
import com.magnus.jdbc.utils.Connector;

import java.lang.reflect.Field;
import java.sql.*;

public class QueryUserDemo {
    public static void main(String[] args) {
        try {
            Connection connection = Connector.getConnectionFromDriver();
            String sql = "select * from user where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,"0000000004");
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columns = resultSetMetaData.getColumnCount();
            while( resultSet.next() ){
                User user = new User();
                for(int i = 0; i < columns; i++){
                    //遍历结果列表，先拿到结果列表的列名
                    String columnName = resultSetMetaData.getColumnName(i+1);
                    //拿到列对应的值
                    Object columnValue = resultSet.getObject(i+1);
                    //通过反射拿到User对象的和列名对应的变量名称
                    Field field = User.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(user,columnValue);
                }
                System.out.println(user.toString());
                System.out.println(user.getAge());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
