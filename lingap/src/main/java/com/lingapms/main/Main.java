package com.lingapms.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.lingapms.dao.DbConnection;
import com.lingapms.dao.UserReadDAO;
import com.lingapms.model.User;

public class Main {
    public static void main(String[] args) {
        DbConnection dbConnection = new DbConnection();
        UserReadDAO readUser = new UserReadDAO(dbConnection);
        System.out.println(readUser.searchUser("mark123"));
    }


}