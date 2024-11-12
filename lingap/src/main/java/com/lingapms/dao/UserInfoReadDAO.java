package com.lingapms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lingapms.model.Patient;

public class UserInfoReadDAO {
    DbConnection dbConnection;

    public UserInfoReadDAO(DbConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    public Patient searchUser(Patient patient){
        String query = "SELECT * FROM user_info_tbl WHERE first_name LIKE ? AND last_name LIKE ? AND age LIKE ?";
        Patient patientFound = null;
        try(Connection connection = dbConnection.connect();
            PreparedStatement prepareStatement = connection.prepareStatement(query);
        ){
            prepareStatement.setString(1, patient.getFirstName());
            prepareStatement.setString(2, patient.getLastName());
            prepareStatement.setInt(3, patient.getAge());
            try(ResultSet resultSet = prepareStatement.executeQuery()){
                if(resultSet.next()){
                    patientFound = new Patient(resultSet.getInt("id"),
                                        resultSet.getString("first_name"),
                                        resultSet.getString("last_name"),
                                        resultSet.getInt("age"),
                                        resultSet.getString("address"),
                                        resultSet.getString("phone"));
                }
            }
            catch(SQLException e){
                System.out.println("UserInfoReadDAO: searchUser() -> " + e);
            }
        }
        catch(SQLException e){
            System.out.println("UserInfoReadDAO: searchUser() -> " + e);
        }
        return patientFound;
    }

}
