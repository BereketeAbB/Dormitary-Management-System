package com.mycompany.dms;

import java.util.Scanner;

/**
 * DORMITARY MANAGEMENT SYSTEM
 * Landing UI Class
 * 
 * @author GROUP ONE
 */

abstract public class UI {
     // An abstract public class which loads the landing page.
    static int logVal;
    static String studName, studID, procName, procID, procPW;
    
    static Scanner inp = new Scanner(System.in);
    
  static void login(){
        System.out.println("- - - D O R M I T A R Y  M A N A G E M E N T  S Y S T E M  - - -");
        System.out.println("Welcome! >");
        System.out.println("This is a Student-Proctor Interaction program.");
        System.out.println("Are you a student/proctor?");
        System.out.println("Enter 1: Studetnt");
        System.out.println("Enter 2: Proctor");
        System.out.println("Enter 3: Exit");
        System.out.println("________________________");
        logVal = inp.nextInt();
        
        switch (logVal){
            case 1:         //Student
                System.out.println("Enter your name. . .");
                studName = inp.next();
                System.out.println("Welcome " + studName + "!");
                
                System.out.println (studName + ", your ID Number please...");
                studID = inp.next();
                        
                System.out.println("Have a good journey!");
                System.out.println("________________________");
                
                Student stud1 = new Student(studName, studID);
                stud1.index();
                
                break;
                
            case 2:           //Proctor
                System.out.println("Enter your name. . .");
                procName = inp.next();
                System.out.println("Welcome " + procName + "!, your ID Number please...");
                procID = inp.next();
                System.out.println(procName + ", your PASSWORD please...");
                procPW = inp.next();
                if (Authentication.isProctor(procName, procPW)){
                    Proctor proc1 = new Proctor(procName, procID);
                    System.out.println("Mr Proctor, Hope Exerything is good.");
                    proc1.index();
                }
                else System.out.println("Username or Password Error! LoginFailed");
                login();
                break;
                
            case 3:         //Exit
                break;
            default:        //Invalid Input
                System.out.println("Insert either 1 or 2");
                login();
        }
    }    
}
