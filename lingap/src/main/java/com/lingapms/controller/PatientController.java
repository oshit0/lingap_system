package com.lingapms.controller;

import com.lingapms.dao.UserInfoUpdateDAO;
import com.lingapms.model.Patient;

public class PatientController {

    private UserInfoUpdateDAO userUpd;

    public PatientController(UserInfoUpdateDAO userUpd){
        this.userUpd = userUpd;
    }

    public boolean createPatientInfo(Patient patient){
        boolean success = userUpd.addUser(patient);
        if(success){
            // TODO Move to PatientView
            System.out.println("Success");
        }
        else{
            System.out.println("Failed");
        }
        return success;
    }
}
