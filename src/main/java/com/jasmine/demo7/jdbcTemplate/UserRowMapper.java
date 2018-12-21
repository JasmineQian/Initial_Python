package com.jasmine.demo7.jdbcTemplate;

import com.jasmine.demo7.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性
        int userId = resultSet.getInt("id");
        String userName = resultSet.getString("name");
        int userAge = resultSet.getInt("age");
        String phone = resultSet.getString("phone");
        String password = resultSet.getString("password");
        User user = new User();
        user.setId(userId);
        user.setName(userName);
        user.setAge(userAge);
        user.setPhone(phone);
        user.setPassword(password);
        return user;

    }
}
