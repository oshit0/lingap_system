package com.lingapms.main;

import com.lingapms.controller.DoctorController;
import com.lingapms.controller.PatientController;
import com.lingapms.controller.UserController;
import com.lingapms.dao.DbConnection;
import com.lingapms.dao.DoctorInfoReadDAO;
import com.lingapms.dao.UserCredentialReadDAO;
import com.lingapms.dao.UserCredentialUpdateDAO;
import com.lingapms.dao.UserInfoReadDAO;
import com.lingapms.model.Patient;
import com.lingapms.service.UserService;
import com.lingapms.view.DoctorView;
import com.lingapms.view.UserView;
import com.lingapms.dao.UserInfoUpdateDAO;


public class Main {
    public static void main(String[] args) {
        DbConnection dbConnection = new DbConnection();

        UserCredentialReadDAO userCredRead = new UserCredentialReadDAO(dbConnection);
        UserCredentialUpdateDAO userCredUpdate = new UserCredentialUpdateDAO(dbConnection);
        UserService service = new UserService(userCredRead, userCredUpdate);
        UserView userView = new UserView();

        UserInfoUpdateDAO userInfoUpd = new UserInfoUpdateDAO(dbConnection);
        UserInfoReadDAO userInfoRead = new UserInfoReadDAO(dbConnection);
        PatientController patientController = new PatientController(userInfoUpd);

        UserController userCont = new UserController(service, userView, userInfoRead, patientController);

        DoctorInfoReadDAO docRead = new DoctorInfoReadDAO(dbConnection);
        DoctorView docView = new DoctorView();
        DoctorController docCont = new DoctorController(dbConnection, docRead, docView);

        userCont.startAuthMenu();
        docCont.startDoctorMenu();
    }
}