package com.lingapms.view;

import com.lingapms.model.User;
import java.util.ArrayList;
import java.util.Scanner;

public class UserView {
    Scanner scn;

    public UserView() {
        scn = new Scanner(System.in);
    }

    public void printTitle() {
        System.out.println("( ___ )--------------------------------------------------------------( ___ )");
        System.out.println(" |   |                                                                |   |");
        System.out.println(" |   | __        __   _                            _                  |   |");
        System.out.println(" |   | \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___            |   |");
        System.out.println(" |   |  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\           |   |");
        System.out.println(" |   |   \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) |          |   |");
        System.out.println(" |   |  _ \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/           |   |");
        System.out.println(" |   | | |   (_)_ __   __ _  __ _ _ __                                |   |");
        System.out.println(" |   | | |   | | '_ \\ / _` |/ _` | '_ \\                               |   |");
        System.out.println(" |   | | |___| | | | | (_| | (_| | |_) |                              |   |");
        System.out.println(" |   | |_____|_|_| |_|\\__, |\\__,_| .__/                          _    |   |");
        System.out.println(" |   | |  \\/  | __ _ _|___/ __ _ |_| _  ___ _ __ ___   ___ _ __ | |_  |   |");
        System.out.println(" |   | | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ '_ ` _ \\ / _ \\ '_ \\| __| |   |");
        System.out.println(" |   | | |  | | (_| | | | | (_| | (_| |  __/ | | | | |  __/ | | | |_  |   |");
        System.out.println(" |   | |_|__|_|\\__,_|_| |_|\\__,_|\\__, |\\___|_| |_| |_|\\___|_| |_|\\__| |   |");
        System.out.println(" |   | / ___| _   _ ___| |_ ___ _|___/__ | |                          |   |");
        System.out.println(" |   | \\___ \\| | | / __| __/ _ \\ '_ ` _ \\| |                          |   |");
        System.out.println(" |   |  ___) | |_| \\__ \\ ||  __/ | | | | |_|                          |   |");
        System.out.println(" |   | |____/ \\__, |___/\\__\\___|_| |_| |_(_)                          |   |");
        System.out.println(" |   |        |___/                                                   |   |");
        System.out.println(" |___|                                                                |___|");
        System.out.println("(_____)--------------------------------------------------------------(_____)");
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

    public void displayLoginPrompt() {
        System.out.println("=====================================================================================");
        System.out.println("\t\tPlease log in.");
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
            System.out.println("\t1. Login");
            System.out.println("\t2. Exit");
            System.out.print("\tChoose an option: ");
            return scn.nextInt();
        } catch (Exception e) {
            displayErrorMessage("Invalid choice input.");
            scn.nextLine();
            return promptUserChoice();
        }

    }

    public boolean promptForConfirmation(String message) {
        try {
            System.out.print(message + " (Y/N): ");
            char choice = scn.next().charAt(0);
            return choice == 'y' || choice == 'Y';
        } catch (Exception e) {
            displayErrorMessage("Invalid confirmation input.");
            return promptForConfirmation(message);
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