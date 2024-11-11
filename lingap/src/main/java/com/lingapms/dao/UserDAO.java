package com.lingapms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lingapms.enums.Role;
import com.lingapms.model.User;

public class UserDAO {

    DbConnection dbConnection;

    public UserDAO(DbConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    public ArrayList<User> fetchUsers(String query){
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

    public ArrayList<User> searchAllUsers(){
        String query = "SELECT * FROM user_credentials_tbl";
        return fetchUsers(query);
    }
}
