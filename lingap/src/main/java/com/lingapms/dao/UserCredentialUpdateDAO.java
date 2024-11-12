package com.lingapms.dao;

import com.lingapms.enums.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lingapms.model.User;

public class UserCredentialUpdateDAO {

    private final DbConnection dbConnection;

    public UserCredentialUpdateDAO(DbConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    private boolean executeUpdateData(User user, String query){
        boolean success = false;
        try (
            Connection connection = dbConnection.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getUserId());
            int roleValue = (user.getRole() == Role.PATIENT) ? 0 : (user.getRole() == Role.NURSE) ? 1 : -1;
            preparedStatement.setInt(4, roleValue);
            if(query.contains("WHERE")){
                preparedStatement.setInt(5, user.getId());
            }
            else{
            }
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected != 0) success = true;
        } catch (SQLException e) {
            System.out.println("UserCredentialUpdateDao: executeUpdateData - " + e);
        }
        return success;
    }

    public boolean addUser(User user){
        String query = "INSERT INTO user_credentials_tbl (username, password, user_id, role) "
                        + "VALUES (?, ?, ?, ?)";
        return executeUpdateData(user, query);
    }

    public boolean updateUser(User user){
        String query = "UPDATE user_credentials_tbl SET username = ?, password = ?, user_id = ?, role = ? WHERE id = ?";
        return executeUpdateData(user, query);
    }
}