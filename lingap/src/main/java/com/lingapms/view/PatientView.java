package com.lingapms.view;

import java.util.Scanner;

import com.lingapms.model.Patient;

public class PatientView {

    private Scanner scn;

    public PatientView(){
        scn = new Scanner(System.in);
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

    public String promptFirstName() {
        try {
            String name = "";
            System.out.print("Enter First Name: ");
            name = scn.nextLine();
            return name;
        } catch (Exception e) {
            displayErrorMessage("Something Happened at UserView: promptName().");
            return promptFirstName();
        }
    }

    public String promptLastName() {
        try {
            String name = "";
            System.out.print("Enter Last Name: ");
            name = scn.nextLine();
            return name;
        } catch (Exception e) {
            displayErrorMessage("Something Happened at UserView: promptName().");
            return promptLastName();
        }
    }

    public int promptAge(){
        try {
            System.out.print("Enter Age: ");
            return scn.nextInt();
        } catch (Exception e) {
            displayErrorMessage("Invalid input for age.");
            return promptAge();
        }
    }

    public String promptAddress(){
        try {
            System.out.print("Enter Address: ");
            return scn.nextLine();
        } catch (Exception e) {
            displayErrorMessage("Something Happened at UserView: promptAddress().");
            return promptAddress();
        }
    }

    public String promptPhone(){
        try {
            System.out.print("Enter Phone: ");
            return scn.nextLine();
        } catch (Exception e) {
            displayErrorMessage("Something Happened at UserView: promptAddress().");
            return promptPhone();
        }
    }

     public Patient promptPatientInfo() {
        Patient patient = new Patient();
        patient.setFirstName(promptFirstName());
        patient.setLastName(promptLastName());
        patient.setAge(promptAge());
        scn.nextLine();
        patient.setAddress(promptAddress());
        patient.setPhoneNumber(promptPhone());
        return patient;

    }

}
