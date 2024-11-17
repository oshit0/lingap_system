package com.lingapms.view;

import java.util.Scanner;

import com.lingapms.model.Patient;
import com.lingapms.service.DateService;

public class PatientView {

    private Scanner scn;
    private DateService dateService;

    public PatientView(DateService dateService){
        scn = new Scanner(System.in);
        this.dateService = dateService;
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

    public int promptUserChoice(Patient patient) {
        try {
            System.out.println("\n");
            System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
            System.out.printf("║                   Welcome %s %s Today is: %s                     ║\n",
            patient.getFirstName(), patient.getLastName(), dateService.getFormattedDate());
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
            return promptUserChoice(patient);
        }
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
