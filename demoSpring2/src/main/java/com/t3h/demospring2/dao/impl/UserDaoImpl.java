package com.t3h.demospring2.dao.impl;

import com.t3h.demospring2.dao.IUserDao;
import com.t3h.demospring2.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    public Connection getConnection()  {
        String connectionString = "jdbc:mysql://localhost:3306/users_managger";
        String username = "root";
        String password = "Strongpass@";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(connectionString, username, password);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<User> getAllUser() {
        Connection connection = getConnection();
        List<User> users = new ArrayList<>();
        if(connection != null){
            String query = "select * from user_master";
            try{
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()){
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setFullName(resultSet.getString("full_name"));
                    user.setAddress(resultSet.getString("address"));
                    user.setUserName(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setRoleId(resultSet.getInt("role_id"));
                    user.setAge(resultSet.getInt("age"));
                    users.add(user);
                }
                connection.close();
                statement.close();
                return users;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
