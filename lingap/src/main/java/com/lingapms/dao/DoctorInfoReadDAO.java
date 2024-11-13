package com.lingapms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lingapms.model.Doctor;
import com.lingapms.model.Schedule;

public class DoctorInfoReadDAO {

    private DbConnection dbConnection;

    public DoctorInfoReadDAO(DbConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    public ArrayList<Doctor> fetchDoctors(){
        String query = "SELECT doctor_info_tbl.id, doctor_info_tbl.name, doctor_info_tbl.field, doctor_info_tbl.schedule_id, doctor_schedules_tbl.day, doctor_schedules_tbl.time, doctor_schedules_tbl.slots_remaining "
                        + "FROM doctor_info_tbl "
                        + "INNER JOIN doctor_schedules_tbl ON doctor_info_tbl.schedule_id = doctor_schedules_tbl.id ";
        ArrayList<Doctor> doctors = new ArrayList<>();
        try (Connection connection = dbConnection.connect();
             Statement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    Schedule schedule = new Schedule(
                        resultSet.getInt("schedule_id"),
                        resultSet.getString("day"),
                        resultSet.getString("time"),
                        resultSet.getInt("slots_remaining")
                    );
                    Doctor doctor = new Doctor(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("field"),
                        schedule
                    );
                    doctors.add(doctor);
                }
            } catch (SQLException e) {
                System.out.println("DoctorInfoReadDAO: fetchDoctors() -> " + e);
            }
        } catch (SQLException e) {
            System.out.println("DoctorInfoReadDAO: fetchDoctors() -> " + e);
        }
        return doctors;
    }

    public Doctor searchDoctor(String name){
        String query = "SELECT doctor_info_tbl.id, doctor_info_tbl.name, doctor_info_tbl.field, doctor_info_tbl.schedule_id, doctor_schedules_tbl.day, doctor_schedules_tbl.time, doctor_schedules_tbl.slots_remaining "
                        + "FROM doctor_info_tbl "
                        + "INNER JOIN doctor_schedules_tbl ON doctor_info_tbl.schedule_id = doctor_schedules_tbl.id "
                        + "WHERE doctor_info_tbl.name LIKE ?";
        name = "%" + name + "%";
        Doctor doctor = null;
        Schedule schedule = null;
        try(Connection connection = dbConnection.connect();
            PreparedStatement prepareStatement = connection.prepareStatement(query);
        ){
            prepareStatement.setString(1, name);
            try(ResultSet resultSet = prepareStatement.executeQuery()){
                while(resultSet.next()){
                    schedule = new Schedule(resultSet.getInt("schedule_id"),
                                            resultSet.getString("day"),
                                            resultSet.getString("time"),
                                            resultSet.getInt("slots_remaining"));
                    doctor = new Doctor(resultSet.getInt("id"),
                                        resultSet.getString("name"),
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