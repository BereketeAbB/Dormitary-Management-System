package com.mycompany.dms;

import java.util.Scanner;
import java.io.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;


/**
 * DORMITARY MANAGEMENT SYSTEM
 * Proctor class extending Person
 *          Contains all methods and operations on Proctor Menu
 * 
 * @author GROUP ONE
 */

public class Proctor extends Person {
    String proctorId;
    
    abstract static class BuildingStatus {                              
        static int regOpen = 0;
        static int water = 0;
        static int electricity = 0;

        static String note;
        static String MajFault;
        static String faultStudId; 
        static int counterNote;
//        String proctorAvailable;

        public static String notePath = "C:/Users/HP/OneDrive/Documents/NetBeansProjects/DMS/src/main/java/com/mycompany/dms/writeOutputs/Notifications.txt";
        public static String majFPath = "C:/Users/HP/OneDrive/Documents/NetBeansProjects/DMS/src/main/java/com/mycompany/dms/writeOutputs/MajorFault.txt";
        public static String minFPath = "C:/Users/HP/OneDrive/Documents/NetBeansProjects/DMS/src/main/java/com/mycompany/dms/writeOutputs/MinorFault.txt";
    }
    //path of output files
    
    
    Scanner inp = new Scanner (System.in);          // Scanner Object
    
   
    public static int getReg(){
        return BuildingStatus.regOpen;
    }
    public static int getElec(){
        return BuildingStatus.electricity;
    }
    public static int getWat(){
        return BuildingStatus.water;
    }
    
   
    Proctor(String name, String procID){
        super(name);
        this.proctorId = procID;
    }
    void index (){
        System.out.println("*********************************");
        System.out.println("Choose and press the buttons to continue");
        System.out.println("1: Attendence");
        System.out.println("2: Register new Students");
        System.out.println("3: Update Building Status");
        System.out.println("4: Record Students Fault");
        System.out.println("5: Send Notification to Students");
        System.out.println("9: SIGN OUT");
        System.out.println("0: Exit");
        
        int indVal = inp.nextInt();
        inp.nextLine();
        
        switch (indVal) {
            case 1:
                signAttendence();
//                System.out.println("On Dev.\n\n");
                index();
                break;
            case 2:
                registerStudents();
                break;
            case 3:
                updateBldgStat();
                break;
            case 4:
                faults();
                break;
            case 5:
                sendNotification();
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
    
    void signAttendence() {
        System.out.println("Attendence Signed!");
    }
    
    void registerStudents(){
        System.out.println("0: Close Registration");
        System.out.println("1: Open Registration");
        int val = inp.nextInt();
        
        switch(val){
        case 0:
            BuildingStatus.regOpen = 0;
            System.out.println("Registration is closed");
            index();
            break;
        
        case 1:
            BuildingStatus.regOpen = 1;
            
            System.out.println(">>> You have opened the registration. Make sure to come and close it when the deadline ends.");
            index();
            break;
        
        default:
            break;
                
        }
    }
    void sendNotification(){
        try {               
            System.out.println("Enter the Notification you want to send.! ");
            BuildingStatus.note = inp.nextLine();
            BufferedWriter FWriter = new BufferedWriter(new FileWriter(BuildingStatus.notePath, true));
            FWriter.write(BuildingStatus.counterNote++ + ", " + BuildingStatus.note + "\n");
            System.out.println("\"" + BuildingStatus.note + "\"" + " has been written!");
            FWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing.");
        }

    }
   
    void updateBldgStat(){
        System.out.println("You can update the status of your building. Choose and use '0' if unavailable and '1' if available.");
        System.out.println("1: Water");
        System.out.println("2: Electricity");
//        System.out.println("//3: Proctor Available nearby");
        System.out.println("0: Back");
        int bldgVal = inp.nextInt();
        
        switch(bldgVal){
            case 0:  
                index();// Proctor Value     
            case 1:                                      // Water Options
                updateWater();
                break;
            case 2:                                      //Electricity Options
                updateElectricity();
                break;
            case 3:
                System.out.println("OnDev!");
                updateBldgStat();
                break;
            default:
                System.out.println("Invalid Option.");
                updateBldgStat();
                break;
            }
        }
        void updateWater(){
                System.out.println("Current status: ");
                System.out.println("0: No Water");
                System.out.println("1: Water Available");
                    int watVal = inp.nextInt();

                    switch (watVal) {
                        case 0:
                            BuildingStatus.water = 0;
                            System.out.println("No Water! Status Added!");
                            updateBldgStat();
                            break;
                        case 1:
                            BuildingStatus.water = 1;
                            System.out.println("Water Available! Status Added!");
                            updateBldgStat();
                            break;  
                        default: 
                            System.out.println("    Wrong Input.!");
                            updateWater();
                            break;
                    }}
        void updateElectricity(){
            System.out.println("0: Electricity Off");
                System.out.println("1: Electricity On");
                    int elecVal = inp.nextInt();

                    switch (elecVal) {
                        case 0:
                            BuildingStatus.electricity = 0;
                            System.out.println("No Electricity! Status Added!");
                            System.out.println("================================");
                            updateBldgStat();
                            break;
                        case 1:
                            BuildingStatus.electricity = 1;
                            System.out.println("Electricity is on! Status Added!");
                            System.out.println("================================");
                            updateBldgStat();
                            break; 
                        default: 
                            System.out.println("    Wrong Input.!");
                            updateElectricity();
                            break;
                    }
        }
        
    void faults(){
        System.out.println("Do not try to execuse your faults, try to CORRECT them!");
        System.out.println("1: Record Faults");
        System.out.println("2: Erase Faults");
        System.out.println("3: Watch Record Lists");
        System.out.println("0: Back") ;
        int recVal = inp.nextInt();
        
        switch(recVal){
            case 0:
                index();
                return;
            case 1:
                recordFaults();
                index();
                break;
            case 2:
                eraseFaults();
                index();
                break;
            case 3:
                try {
                BufferedReader MajFaultRead = new BufferedReader(new FileReader (majFPath));
                while((BuildingStatus.MajFault =MajFaultRead.readLine()) != null){
                    System.out.println(BuildingStatus.MajFault);
                }                     
                MajFaultRead.close();
                }
                catch (IOException ex){
                    System.out.println("Read Error: " + ex);
                }
            default:
                faults();
                break;
        }
    }
        void recordFaults(){
            System.out.println("Enter ID number");
            BuildingStatus.faultStudId = inp.next();
                
            System.out.println("Fault Types");
            System.out.println("1: Minor Faults");
            System.out.println("2: Major Faults") ;

            System.out.println("0: Back") ;
                int recVal = inp.nextInt();
                    try {
                        
                            switch (recVal){
                                case 0:
                                    faults();
                                    break;
                                case 1:
                                    BuildingStatus.faultType = 1;
                                    BufferedWriter FWriter = new BufferedWriter(new FileWriter(BuildingStatus.majFPath, true));
                                    System.out.println("Student, " + BuildingStatus.faultStudId + ",  is recorded with a minor fault. ");
                                    FWriter.write(BuildingStatus.faultStudId + "\n");
                                    FWriter.close();
                                    break;
                                case 2:
                                    BuildingStatus.faultType = 2;
                                    BufferedWriter F1Writer = new BufferedWriter(new FileWriter(BuildingStatus.minFPath, true));
                                    System.out.println("Student, " + BuildingStatus.faultStudId + ",  is recorded with a MAJOR fault. Take Care!");
                                    F1Writer.write(BuildingStatus.faultStudId + "\n");
                                    F1Writer.close();
                                    break;
                                
                                default:
                                    System.out.println("Invalid Input!");
                                    recordFaults();
                            }
                    } catch (IOException ex) {
                        System.out.println("Major Student filing failed.");
                    }

                    
                                // send the data to the database
                }
        void eraseFaults(){
            System.out.println("On Dev");
            faults();
        }
            
}
