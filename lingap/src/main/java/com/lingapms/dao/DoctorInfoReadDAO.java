package com.lingapms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lingapms.model.Doctor;
import com.lingapms.model.Schedule;

public class DoctorInfoReadDAO {

    private DbConnection dbConnection;

    public DoctorInfoReadDAO(DbConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    public Doctor searchDoctor(String username){
        String query = "SELECT doctor_info_tbl.name, doctor_info_tbl.field, doctor_schedules_tbl.day, doctor_schedules_tbl.time, doctor_schedules_tbl.slots_remaining "
                        + "FROM doctor_info_tbl "
                        + "INNER JOIN doctor_schedules_tbl ON doctor_info_tbl.schedule_id = doctor_schedules_tbl.id "
                        + "WHERE doctor_info_tbl.name LIKE ?";
        username = "%" + username + "%";
        Doctor doctor = null;
        Schedule schedule = null;
        try(Connection connection = dbConnection.connect();
            PreparedStatement prepareStatement = connection.prepareStatement(query);
        ){
            prepareStatement.setString(1, username);
            try(ResultSet resultSet = prepareStatement.executeQuery()){
                while(resultSet.next()){
                    schedule = new Schedule(resultSet.getString("day"),
                                            resultSet.getString("time"),
                                            resultSet.getInt("slots_remaining"));
                    doctor = new Doctor(resultSet.getString("name"),
                                        resultSet.getString("field"),
                                        schedule);
                }
            }
            catch(SQLException e){
                System.out.println("DoctorInfoReadDAO: searchDoctor() -> " + e);
            }
        }
        catch(SQLException e){
            System.out.println("DoctorInfoReadDAO: searchDoctor() -> " + e);
        }
        return doctor;
    }
}
