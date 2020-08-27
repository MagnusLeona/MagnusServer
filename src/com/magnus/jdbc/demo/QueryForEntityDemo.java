package com.magnus.jdbc.demo;

import com.magnus.jdbc.entity.User;
import com.magnus.jdbc.query.QueryForEntity;

public class QueryForEntityDemo {
    public static void main(String[] args) {
        User user = new User();
        QueryForEntity queryForEntity = new QueryForEntity();
        String sql = "select * from user where id=?";
        user = queryForEntity.queryForMap(User.class,sql, new String[]{"0000000001"});
        System.out.println(user.getAge());
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getDescription());
    }
}
