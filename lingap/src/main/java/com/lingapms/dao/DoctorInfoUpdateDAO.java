package com.lingapms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.lingapms.model.Doctor;

public class DoctorInfoUpdateDAO {

    private final DbConnection dbConnection;

    public DoctorInfoUpdateDAO(DbConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    private boolean executeUpdateData(Doctor doctor, String query){
        boolean success = false;
        try (
            Connection connection = dbConnection.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, doctor.getName());
            preparedStatement.setString(2, doctor.getField());
            preparedStatement.setInt(3, doctor.getSchedule().getId());
            preparedStatement.setInt(4, doctor.getSchedule().getSlotsRemaining());
            if(query.contains("WHERE")){
                preparedStatement.setInt(5, doctor.getId());
            }
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected != 0) success = true;
        } catch (SQLException e) {
            System.out.println("DoctorInfoUpdateDAO: executeUpdateData - " + e);
        }
        return success;
    }

    public boolean addDoctor(Doctor doctor){
        String query = "INSERT INTO doctor_info_tbl (name, field, schedule_id, slots_remaining) "
                        + "VALUES (?, ?, ?, ?)";
        return executeUpdateData(doctor, query);
    }

    public boolean updateDoctor(Doctor doctor){
        String query = "UPDATE doctor_info_tbl SET name = ?, field = ?, schedule_id = ? slots_remaining = ? WHERE id = ?";
        return executeUpdateData(doctor, query);
    }
}