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
        center();
        System.out.println("( ___ )--------------------------------------------------------------( ___ )");
        center();
        System.out.println(" |   |                                                                |   |");
        center();
        System.out.println(" |   | __        __   _                            _                  |   |");
        center();
        System.out.println(" |   | \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___            |   |");
        center();
        System.out.println(" |   |  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\           |   |");
        center();
        System.out.println(" |   |   \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) |          |   |");
        center();
        System.out.println(" |   |  _ \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/           |   |");
        center();
        System.out.println(" |   | | |   (_)_ __   __ _  __ _ _ __                                |   |");
        center();
        System.out.println(" |   | | |   | | '_ \\ / _` |/ _` | '_ \\                               |   |");
        center();
        System.out.println(" |   | | |___| | | | | (_| | (_| | |_) |                              |   |");
        center();
        System.out.println(" |   | |_____|_|_| |_|\\__, |\\__,_| .__/                          _    |   |");
        center();
        System.out.println(" |   | |  \\/  | __ _ _|___/ __ _ |_| _  ___ _ __ ___   ___ _ __ | |_  |   |");
        center();
        System.out.println(" |   | | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ '_ ` _ \\ / _ \\ '_ \\| __| |   |");
        center();
        System.out.println(" |   | | |  | | (_| | | | | (_| | (_| |  __/ | | | | |  __/ | | | |_  |   |");
        center();
        System.out.println(" |   | |_|__|_|\\__,_|_| |_|\\__,_|\\__, |\\___|_| |_| |_|\\___|_| |_|\\__| |   |");
        center();
        System.out.println(" |   | / ___| _   _ ___| |_ ___ _|___/__ | |                          |   |");
        center();
        System.out.println(" |   | \\___ \\| | | / __| __/ _ \\ '_ ` _ \\| |                          |   |");
        center();
        System.out.println(" |   |  ___) | |_| \\__ \\ ||  __/ | | | | |_|                          |   |");
        center();
        System.out.println(" |   | |____/ \\__, |___/\\__\\___|_| |_| |_(_)                          |   |");
        center();
        System.out.println(" |   |        |___/                                                   |   |");
        center();
        System.out.println(" |___|                                                                |___|");
        center();
        System.out.println("(_____)--------------------------------------------------------------(_____)");
    }

    public void refreshBuffer() {
        scn.nextLine();
    }

    public void center() {
        System.out.print("\t\t\t\t\t\t");
    }

    public void middle(){
        System.out.println("\n\n\n\n\n");
    }

    public final void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void closeScanner() {
        if (scn != null) {
            scn.close();
        }
    }

    public void displayErrorMessage(String message) {
        clearConsole();
        middle();
        center();
        System.out.println("=====================================================================================");
        center();
        System.out.println("\t\tError: " + message);
        center();
        System.out.println("=====================================================================================");
    }

    public void displaySuccessMessage(String message) {
        center();
        System.out.println("=====================================================================================");
        center();
        System.out.println("\t\tSuccess: " + message);
        center();
        System.out.println("=====================================================================================");
    }

    public void displayLoginPrompt() {
        center();
        System.out.println("=====================================================================================");
        center();
        System.out.println("\t\tPlease log in.");
        center();
        System.out.println("=====================================================================================");
    }

    public void displayWelcomeMessage() {
        center();
        System.out.println("=====================================================================================");
        center();
        System.out.println("\t\tWelcome back!");
        center();
        System.out.println("=====================================================================================");
    }

    public void displayInvalidCredentialsMessage() {
        center();
        System.out.println("=====================================================================================");
        center();
        System.out.println("\t\tInvalid username or password.");
        center();
        System.out.println("=====================================================================================");
    }

    public int promptUserChoice() {
        try {
            System.out.println("\n");
            System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                              Main Menu                               ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
            System.out.println("║                                                                      ║");
            System.out.println("║    1. Login                                                          ║");
            System.out.println("║    2. Exit                                                           ║");
            System.out.println("║                                                                      ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
            System.out.println();
            System.out.print("* Choose an option: ");
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
            System.out.println("\t");
            center();
            System.out.print("Enter username: ");
            return scn.nextLine();
        } catch (Exception e) {
            displayErrorMessage("Invalid input for username.");
            return promptUsername();
        }
    }

    public String promptPassword() {
        try {
            center();
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
        center();
        System.out.println("=====================================================================================");
        users.forEach((user) -> {
            center();
            System.out.println("User ID: " + user.getId() + ", Username: " + user.getUsername());
        });
        center();
        System.out.println("=====================================================================================");
    }

    public void displayUserProfile(User user) {

        center();
        System.out.println("=====================================================================================");
        center();
        System.out.println("User ID: " + user.getUserId());
        center();
        System.out.println("Username: " + user.getUsername());
        center();
        System.out.println("=====================================================================================");
    }

    public void displayGoodbyeMessage() {
        center();
        System.out.println("=====================================================================================");
        center();
        System.out.println("Goodbye!");
        center();
        System.out.println("=====================================================================================");
    }

    public void displayUserList(String l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayUserProfile(String nurse_nurse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}