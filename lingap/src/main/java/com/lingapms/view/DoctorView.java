package com.lingapms.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.lingapms.model.Doctor;

public class DoctorView {

    private Scanner scn;

    public DoctorView(){
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

    public int promptUserChoice() {
        try {
            System.out.println("=====================================================================================");
            System.out.println("\t1. Print Doctor and Schedules");
            System.out.println("\t2. Search for Doctor");
            System.out.println("\t3. Back");
            System.out.print("\tChoose an option: ");
            return scn.nextInt();
        } catch (Exception e) {
            displayErrorMessage("Invalid choice input.");
            scn.nextLine();
            return promptUserChoice();
        }
    }

    public String promptDoctorName(){
        try {
            System.out.println("=====================================================================================");
            System.out.print("\tEnter Doctor Name: ");
            return scn.nextLine();
        } catch (Exception e) {
            displayErrorMessage("Invalid choice input.");
            return promptDoctorName();
        }

    }

    public void displayDoctorsList(ArrayList<Doctor> doctors) {
        System.out.println("=====================================================================================");
        doctors.forEach((doctor) -> {
            System.out.println("Doctor ID: " + doctor.getId() + ", Name: " + doctor.getName() + ", Field: " + doctor.getField());
            System.out.println("Day: " + doctor.getSchedule().getDay() + ", Time: " + doctor.getSchedule().getTime() + ", Field: " + doctor.getSchedule().getSlotsRemaining());
        });
        System.out.println("=====================================================================================");
    }

    public void displayDoctor(Doctor doctor) {
        System.out.println("=====================================================================================");
        System.out.println("Doctor ID: " + doctor.getId() + ", Name: " + doctor.getName() + ", Field: " + doctor.getField());
        System.out.println("Day: " + doctor.getSchedule().getDay() + ", Time: " + doctor.getSchedule().getTime() + ", Field: " + doctor.getSchedule().getSlotsRemaining());
        System.out.println("=====================================================================================");
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

}
