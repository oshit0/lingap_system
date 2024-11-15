package com.lingapms.controller;

import com.lingapms.dao.UserInfoUpdateDAO;
import com.lingapms.model.Patient;
import com.lingapms.view.PatientView;

public class PatientController {

    private UserInfoUpdateDAO userInfoUpd;
    private PatientView patientView;

    public PatientController(UserInfoUpdateDAO userInfoUpd, PatientView patientView){
        this.userInfoUpd = userInfoUpd;
        this.patientView = patientView;
    }

    public int createPatientInfo(){
        Patient patient = patientView.promptPatientInfo();
        return userInfoUpd.addUser(patient);
    }
}
