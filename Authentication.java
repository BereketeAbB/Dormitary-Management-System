package com.mycompany.dms;

/**
 * DORMITARY MANAGEMENT SYSTEM
 * A module which authenticates proctor's login.
 * 
 * @author GROUP ONE
 */
abstract public class Authentication {
     static String[] proctorsList = {"A", "B", "C"};
     static String[] proctorsPW = {"123A", "123A", "123A"};
     
        static boolean isProctor(String name, String password){
           for(int i = 0; i <= 2; i++){
               if (name.equals(proctorsList[i])){
                   if (password.equals(proctorsPW[i])){
                       return true;
                   }
               }
           }
           return false;
        }
}
