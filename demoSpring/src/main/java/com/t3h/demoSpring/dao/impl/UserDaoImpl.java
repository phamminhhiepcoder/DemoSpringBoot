package com.t3h.demoSpring.dao.impl;

import com.mysql.cj.protocol.PacketReceivedTimeHolder;
import com.t3h.demoSpring.dao.IUserDao;
import com.t3h.demoSpring.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/user_manager";
        String username = "root";
        String password = "Strongpass@";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
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
                    user.setAge(resultSet.getInt("age"));
                    user.setRoleId(resultSet.getInt("roleId"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    users.add(user);
                }
            }catch(SQLException sqle){
                sqle.printStackTrace();
            }
        }
        return users;
    }
}
