package com.jasmine.demo7.service;


import com.jasmine.demo7.entity.User;
import com.jasmine.demo7.jdbcTemplate.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * @Description:查询所有用户
     * @return 返回一个列表
     */
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> userList = jdbcTemplate.query(sql,new UserRowMapper() );
        return userList;
    }


    /**
     * @Description:根据用户ID查询用户信息
     * @param userId
     * @return 返回单个对象
     */
    @Override
    public User findById(int userId) {
        String sql = "select * from user where id = ?";
        User user = jdbcTemplate.queryForObject(sql,new UserRowMapper(),userId);
        return user;
    }


    /**
     * @Description:新增用户
     * @return 返回更新行数
     */

    @Override
    public int create(String name, int age, String phone, String password) {
        String sql = "insert into user(name,age,phone,password) values(?,?,?,?)";
        return jdbcTemplate.update(sql,name,age,phone,password);
    }


    /**
     * @Description:根据用户ID修改用户信息
     * @return 返回更新行数
     */
    @Override
    public int update(int id,String name, int age, String phone, String password) {
        String sql = "update user set name = ? , age = ? , phone = ? ,password = ? where id = ?";
        return jdbcTemplate.update(sql,name,age,phone,password,id);
    }


    /**
     * @Description:根据用户ID删除用户信息
     * @param userId
     * @return 返回更新行数
     */
    @Override
    public int delete(int userId) {
        String sql = "delete from user where id = ?";
        return jdbcTemplate.update(sql, userId);
    }

}
