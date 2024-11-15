package com.lingapms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserCredentialDeleteDAO {

    DbConnection dbConnection;

    public UserCredentialDeleteDAO(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
    public boolean deleteUserById(int userId) {
        String query = "DELETE FROM user_credentials_tbl WHERE id = ?";
        try (Connection connection = dbConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("UserCredentialDeleteDAO: deleteUserById() -> " + e);
            return false;
        }
    }

    public boolean deleteUserByUsername(String username) {
        String query = "DELETE FROM user_credentials_tbl WHERE username = ?";
        try (Connection connection = dbConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("UserCredentialDeleteDAO: deleteUserByUsername() -> " + e);
            return false;
        }
    }
}