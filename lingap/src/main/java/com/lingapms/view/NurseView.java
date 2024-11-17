package com.lingapms.view;

import com.lingapms.model.User;
import java.util.ArrayList;
import java.util.Scanner;

public class NurseView {
    Scanner scn;

    public NurseView() {
        scn = new Scanner(System.in);
    }

    public void refreshBuffer() {
        scn.nextLine();
    }

    public void closeScanner() {
        if (scn != null) {
            scn.close();
        }
    }

    public void displayErrorMessage(String message) {
        System.out.println("=====================================================================================");
        System.out.println("\t\tError: " + message);
        System.out.println("=====================================================================================");
    }

    public void displaySuccessMessage(String message) {
        System.out.println("=====================================================================================");
        System.out.println("\t\tSuccess: " + message);
        System.out.println("=====================================================================================");
    }

    public void displayRegistrationPrompt() {
        System.out.println("=====================================================================================");
        System.out.println("\t\tPlease register.");
        System.out.println("=====================================================================================");
    }

    public void displayWelcomeMessage() {
        System.out.println("=====================================================================================");
        System.out.println("\t\tWelcome back!");
       System.out.println("=====================================================================================");
    }

    public void displayInvalidCredentialsMessage() {
        System.out.println("=====================================================================================");
        System.out.println("\t\tInvalid username or password.");
        System.out.println("=====================================================================================");
    }

    public int promptUserChoice() {
        try {
            System.out.println("=====================================================================================");
            System.out.println("\t1. Add New Patient");
            System.out.println("\t2. Edit Patient Info");
            System.out.println("\t3. Add New Doctor");
            System.out.println("\t4. Edit Doctor Info");
            System.out.println("\t5. Add Schedules");
            System.out.println("\t6. Edit Schedules");
            System.out.print("\t7. Logout");
            return scn.nextInt();
        } catch (Exception e) {
            displayErrorMessage("Invalid choice input.");
            scn.nextLine();
            return promptUserChoice();
        }

    }
    public String promptUsername() {
        try {
            System.out.print("Enter username: ");
            return scn.nextLine();
        } catch (Exception e) {
            displayErrorMessage("Invalid input for username.");
            return promptUsername();
        }
    }

    public String promptPassword() {
        try {
            System.out.print("Enter password: ");
            return scn.nextLine();
        } catch (Exception e) {
            displayErrorMessage("Invalid input for password.");
            return promptPassword();
        }
    }

     public User promptUserCredentials() {
        String username = promptUsername();
        String password = promptPassword();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

    public void displayUserList(ArrayList<User> users) {
        System.out.println("=====================================================================================");
        users.forEach((user) -> {
            System.out.println("User ID: " + user.getId() + ", Username: " + user.getUsername());
        });
        System.out.println("=====================================================================================");
    }

    public void displayUserProfile(User user) {
        System.out.println("=====================================================================================");
        System.out.println("User ID: " + user.getUserId());
        System.out.println("Username: " + user.getUsername());
        System.out.println("=====================================================================================");
    }

    public void displayGoodbyeMessage() {
        System.out.println("=====================================================================================");
        System.out.println("Goodbye!");
        System.out.println("=====================================================================================");
    }

    public void displayUserList(String l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayUserProfile(String nurse_nurse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}