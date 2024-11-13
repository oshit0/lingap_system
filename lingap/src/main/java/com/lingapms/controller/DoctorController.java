package com.lingapms.controller;

import java.util.ArrayList;

import com.lingapms.dao.DbConnection;
import com.lingapms.dao.DoctorInfoReadDAO;
import com.lingapms.model.Doctor;
import com.lingapms.view.DoctorView;

public class DoctorController {

    private DbConnection dbConnection;
    private DoctorInfoReadDAO doctorRead;
    private DoctorView doctorView;
    private int userChoice;

    public DoctorController(DbConnection dbConnection, DoctorInfoReadDAO doctorRead, DoctorView doctorView){
        this.dbConnection = dbConnection;
        this.doctorRead = doctorRead;
        this.doctorView = doctorView;
    }

    public ArrayList<Doctor> retrieveDoctors(){
        return doctorRead.fetchDoctors();
    }

    public Doctor searchForDoctor(String name){
        return doctorRead.searchDoctor(name);
    }


    public void displayUserMenu(){
        userChoice = doctorView.promptUserChoice();
    }

    public boolean handleUserInput(){
        doctorView.refreshBuffer();
        switch(userChoice){
            case 1:
                doctorView.displayDoctorsList(retrieveDoctors());
                break;
            case 2:
                String name = doctorView.promptDoctorName();
                doctorView.displayDoctor(searchForDoctor(name));
                break;
            case 3:
                return true;
        }
        return false;
    }

    public void startDoctorMenu(){
        boolean goBack = false;
        while(!goBack){
            displayUserMenu();
            goBack = handleUserInput();
        }
    }
}
