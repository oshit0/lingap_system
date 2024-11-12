package com.lingapms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserCredentialDeleteDAO {

    DbConnection dbConnection;

    public UserCredentialDeleteDAO(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
    public boolean deleteUserById(int userId) {
        Scanner s = new Scanner(System.in);
        String query = "DELETE FROM user_credentials_tbl WHERE id = ?";
        System.out.println("Delete:");
        int id = s.nextInt();
        try (Connection connection = dbConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("\u001B[31mUser deleted successfully!\u001B[30m");
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("UserDeleteDAO: deleteUserById() -> " + e);
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