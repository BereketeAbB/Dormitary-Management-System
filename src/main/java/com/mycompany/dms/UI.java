/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dms;

import java.util.Scanner;

/**
 *
 * @author bereketeab
 */

public class UI {
       
    static int logVal;
    static String studName, studID, procName, procID ;
    
    static Scanner inp = new Scanner(System.in);
    
//    public void login(){
//        System.out.println("- - - D O R M I T A R Y  M A N A G E M E N T  S Y S T E M  - - -");
//        System.out.println("Welcome! \n>\n>");
//        System.out.println("________________________");
//        System.out.println("Enter 1: Studetnt");
//        System.out.println("Enter 2: Proctor");
//        System.out.println("Enter 3: Exit");
//        logVal = inp.nextInt();
//        
//        switch (logVal){
//            case 1:
//                System.out.println("Enter your name. . .");
//                studName = inp.next();
//                System.out.println("Welcome " + studName + "!");
//                
//                System.out.println (studName + ", your ID Number please...");
//                studID = inp.next();
//                        
//                System.out.println("Have a good journey!");
//                System.out.println("________________________");
//                
//                Student stud1 = new Student(studName, studID);
//                stud1.index();
//                
//                break;
//                
//            case 2:
//                System.out.println("Enter your name. . .");
//                procName = inp.next();
//                System.out.println("Welcome " + procName + "!, your ID Number please...");
//                procID = inp.next();
//                Proctor proc1 = new Proctor(procName, procID);
//                System.out.println("Mr Proctor, Hope Exerything is good.");
//                proc1.index();
//                break;
//                
//            default: 
//                System.out.println("Insert either 1 or 2");
//                login();
//        }
//    }

  static void login(){
        System.out.println("- - - D O R M I T A R Y  M A N A G E M E N T  S Y S T E M  - - -");
        System.out.println("Welcome! >");
        System.out.println("________________________");
        System.out.println("Enter 1: Studetnt");
        System.out.println("Enter 2: Proctor");
        System.out.println("Enter 3: Exit");
        logVal = inp.nextInt();
        
        switch (logVal){
            case 1:
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
                
            case 2:
                System.out.println("Enter your name. . .");
                procName = inp.next();
                System.out.println("Welcome " + procName + "!, your ID Number please...");
                procID = inp.next();
                Proctor proc1 = new Proctor(procName, procID);
                System.out.println("Mr Proctor, Hope Exerything is good.");
                proc1.index();
                break;
                
            case 3:
                break;
            default: 
                System.out.println("Insert either 1 or 2");
                login();
        }
    }    
}
