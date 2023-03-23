package com.mycompany.dms;

import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * DORMITARY MANAGEMENT SYSTEM
 * Student class extending Person
 *          Contains all methods and operations on Student Menu
 * 
 * @author GROUP ONE
 */

public class Student extends Person {
    String studentId, department;
    int year;
    
    String note;
    Scanner inp = new Scanner (System.in);          // Scanner Object
    
    String regPath = "C:/Users/HP/OneDrive/Documents/NetBeansProjects/DMS/src/main/java/com/mycompany/dms/writeOutputs/StudList.txt";

    Student(String name, String ID){
        super(name);
        this.studentId = ID;
    }

    void index(){
        System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
        System.out.println(" ");
        System.out.println("Choose and press the buttons to continue");
        System.out.println("1: Register");
        System.out.println("2: Check Building Status");
        System.out.println("3: Check Notification");
//        System.out.println("//4: Request Proctor");
//        System.out.println("//5: P2P Notificaiton");
        System.out.println("9: SIGN OUT");
        System.out.println("0: Exit");
        
        int indVal = inp.nextInt();
        inp.nextLine();
        
        switch (indVal) {
            case 1:
                register();
                index();
                break;
            case 2:
                checkStatus();
                index();
                break;
            case 3:
                checkNotification();
                index();
                break;
            case 4:
//                sendNotification();
                System.out.println("On Dev.\n\n");
                index();
                break;
            case 5:
//                sendNotification();
                System.out.println("On Dev.\n\n");
                index();
                break;
            case 9:
                UI.login();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid Input.");
                index();
                break;
        }
    }    
    void register(){
//            if (Proctor.regOpen == 0){
        if (Proctor.getReg() == 0){
            System.out.println("Registration is currently closed. Please contact the Proctor newrby.");
            return;
        }
        try {
        BufferedWriter regWrite = new BufferedWriter(new FileWriter(regPath, true));
            System.out.println("Enter your name:");
                name = inp.nextLine();
            System.out.println("Enter your ID:");
                studentId = inp.nextLine();
            System.out.println("Enter your Department:");
                department = inp.nextLine();
            System.out.println("Enter your Batch:");
                year = inp.nextInt();
                inp.nextLine();
    //            age = inp.nextInt();
            
        System.out.println("You have been registerd, " + name + "! Have a good time with us.");
        regWrite.write(name + ", " + studentId + ", " + department + ", " + year  + "\n");
        regWrite.close();
        // streaming to the Registration form file - append
        } catch (IOException ex) {
            System.out.println("Register Error: " + ex);
        } 
    }        
    void checkStatus(){
        int reg, elec, wat;
        reg = Proctor.BuildingStatus.regOpen;
        elec = Proctor.BuildingStatus.electricity;
        wat = Proctor.BuildingStatus.water;
        
        System.out.println("==========================");
        System.out.println("======Bulding Status======");
        System.out.println("==========================");
        if (wat == 0) System.out.println(">> Water          Unavailable");
        else System.out.println(">> Water          Available");
        
        if (elec == 0) System.out.println(">> Electricity    Unavailable");
        else System.out.println(">> Electricity    Available");
        
        if (reg == 0) System.out.println(">> Registration   Closed");
        else System.out.println(">>Registration    Open");
        
        System.out.println("==========================");
        System.out.println("=========================="); 
        
    }
    void checkNotification(){
            
        try{
            BufferedReader read = new BufferedReader(new FileReader(Proctor.BuildingStatus.notePath));
            System.out.println("Notifications:");
            System.out.println("______________________________");
            while ((note = read.readLine()) != null){
                System.out.println(note);
            }
            read.close();
        } catch (IOException ex) {
            System.out.println("Reading Error");
        }
            
    }  
    void requestProctor(){
        System.out.println("On Dev");
        index();
        //Leave card
        
    }
    
}
