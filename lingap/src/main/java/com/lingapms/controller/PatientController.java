package com.lingapms.controller;

import com.lingapms.dao.UserInfoReadDAO;
import com.lingapms.dao.UserInfoUpdateDAO;
import com.lingapms.model.Patient;
import com.lingapms.view.PatientView;

public class PatientController {

    private UserInfoReadDAO userInfoRead;
    private UserInfoUpdateDAO userInfoUpd;
    private PatientView patientView;
    private Patient patient;
    private int userChoice;

    public PatientController(UserInfoReadDAO userInfoRead, UserInfoUpdateDAO userInfoUpd, PatientView patientView){
        this.userInfoRead = userInfoRead;
        this.userInfoUpd = userInfoUpd;
        this.patientView = patientView;
    }

    public int createPatientInfo(){
        Patient patient = patientView.promptPatientInfo();
        return userInfoUpd.addUser(patient);

    }

    public void displayUserMenu(int userId){
        patient = userInfoRead.searchUser(userId);
        userChoice = patientView.promptUserChoice(patient);
    }

    // public boolean handleUserInput(){
    //     switch(userChoice){
    //         case 1:
    //             return login();
    //         case 2:
    //             patientView.displayGoodbyeMessage();
    //             System.exit(0);
    //         default:
    //             patientView.displayErrorMessage("Invalid Input, Try Again.");
    //     }
    //     return false;
    // }

    // public User startAuthMenu(){
    //     userView.printTitle();
    //     boolean loggedIn = false;
    //     while(!loggedIn){
    //         displayUserMenu();
    //         loggedIn = handleUserInput();
    //     }
    //     return this.user;
    // }
}
