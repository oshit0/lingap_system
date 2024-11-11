package com.lingapms.main;

import java.util.ArrayList;


import com.lingapms.dao.DbConnection;
import com.lingapms.dao.UserDAO;
import com.lingapms.model.User;

public class Main {
    public static void main(String[] args) {
        DbConnection dbConnection = new DbConnection();
        UserDAO readUser = new UserDAO(dbConnection);
        ArrayList<User> users;
        users = readUser.searchAllUsers();

        users.forEach(System.out::println);
    }


}