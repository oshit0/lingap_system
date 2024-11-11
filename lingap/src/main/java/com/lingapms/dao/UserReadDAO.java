package com.lingapms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lingapms.enums.Role;
import com.lingapms.model.User;

public class UserReadDAO {

    DbConnection dbConnection;

    public UserReadDAO(DbConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    public ArrayList<User> fetchUsers(){
        String query = "SELECT * FROM user_credentials_tbl";
        ArrayList<User> users = new ArrayList<>();
        try(Connection connection = dbConnection.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
        ){
            while(resultSet.next()){
                users.add(new User(resultSet.getInt("id"),
                                    resultSet.getString("username"),
                                    resultSet.getString("password"),
                                    (resultSet.getInt("role") == 0) ? Role.PATIENT : Role.NURSE));
            }
        }
        catch(SQLException e){
            System.out.println("UserReadDAO: fetchUsers() -> " + e);
        }
        return users;
    }
    public User searchUser(String username){
        String query = "SELECT * FROM user_credentials_tbl WHERE username LIKE ?";
        username = "%" + username + "%";
        User user = null;
        try(Connection connection = dbConnection.connect();
            PreparedStatement prepareStatement = connection.prepareStatement(query);
        ){
            prepareStatement.setString(1, username);
            try(ResultSet resultSet = prepareStatement.executeQuery()){
                while(resultSet.next()){
                    user = new User(resultSet.getInt("id"),
                                        resultSet.getString("username"),
                                        resultSet.getString("password"),
                                        (resultSet.getInt("role") == 0) ? Role.PATIENT : Role.NURSE);
                }
            }
            catch(SQLException e){
                System.out.println("UserReadDAO: searchUser() -> " + e);
            }
        }
        catch(SQLException e){
            System.out.println("UserReadDAO: searchUser() -> " + e);
        }
        return user;
    }
}
