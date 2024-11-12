package com.lingapms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lingapms.model.Patient;

public class UserInfoUpdateDAO {

    private final DbConnection dbConnection;

    public UserInfoUpdateDAO(DbConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    private boolean executeUpdateData(Patient patient, String query){
        boolean success = false;
        try (
            Connection connection = dbConnection.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, patient.getFirstName());
            preparedStatement.setString(2, patient.getLastName());
            preparedStatement.setInt(3, patient.getAge());
            preparedStatement.setString(4, patient.getAddress());
            preparedStatement.setString(5, patient.getPhoneNumber());
            if(query.contains("WHERE")){
                preparedStatement.setInt(6, patient.getId());
            }
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected != 0) success = true;
        } catch (SQLException e) {
            System.out.println("UserInfoUpdateDAO: executeUpdateData - " + e);
        }
        return success;
    }

    public boolean addUser(Patient patient){
        String query = "INSERT INTO user_info_tbl (first_name, last_name, age, address, phone) "
                        + "VALUES (?, ?, ?, ?, ?)";
        return executeUpdateData(patient, query);
    }

    public boolean updateUser(Patient patient){
        String query = "UPDATE user_info_tbl SET first_name = ?, last_name = ?, age = ?, address = ?, phone = ? WHERE id = ?";
        return executeUpdateData(patient, query);
    }
}