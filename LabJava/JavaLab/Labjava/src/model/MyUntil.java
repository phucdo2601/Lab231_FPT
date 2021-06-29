/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;

/**
 *
 * @author ThanhLiemPro
 */
public class MyUntil {
    
    
    Scanner sc = new Scanner(System.in);
    
    
    public int getIntNumber(String msg){
        while(true){
            try{
                System.out.print(msg);
                return Integer.valueOf(sc.nextLine().trim());
            }catch(NumberFormatException e){
                System.out.println("\n\n**Must be number not character or decimal number!**\n\n");
            }
        }
    }  
    public String getMail(String msg){
        String checkMail;
        while(true){
            System.out.print(msg);
            checkMail = String.valueOf(sc.nextLine()).trim();
            if(checkMail.matches("[a-zA-Z0-9]+@gmail.com$")){
                return checkMail;
            }
            else{
                System.out.println("\n\n**Please try again ( xyz@gmail.com )!**\n\n");
            }
        }
    }
    
    public String getString(String msg1,String msg2){
       boolean check = true;
       String str;
       do{
           System.out.print(msg1);
           str = String.valueOf(sc.nextLine().trim());
           if(str.equals("") ) {      
               System.out.println(msg2);
               check = false;
           }
           else {
               return str.toUpperCase();
            } 
       }while(check==false);
       return null;
    }
    
    
    public String getID(String msg){
        boolean check = true;
        String ID = ""; 
        do{
            System.out.print(msg);
            ID = String.valueOf(sc.nextLine().trim().toUpperCase());
            if(ID.matches("^(SE)\\d{6}")){
               return ID; 
            }
            else{
                System.out.println("\n\n**Please try agian( SE and 6 digits)!!**\n\n");
                check = false;
            }
            
        }while(check==false);
       return null;
    }
    public String getPhoneNumber(String msg){
        String phoneNumber;
        while(true){
            System.out.print(msg);
            phoneNumber = String.valueOf(sc.nextLine().trim());
            if(phoneNumber.matches("\\d{10,12}")){
                return phoneNumber;
            }
            else{
                System.out.println("\n\n**Please try again ( must be 10 digits )!**\n\n");
            }
        }
    }
  public String getDate(String msg){
        String date="";
        boolean check = true;
        while(true){
            System.out.print(msg);
            date = String.valueOf(sc.nextLine());
            if(date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}$")){
                String[] checkDate = date.split("/");
                int day = Integer.parseInt(checkDate[0]);
                int month = Integer.parseInt(checkDate[1]);
                int year = Integer.parseInt(checkDate[2]);
                if(year%100==0){
                    if(year%400==0){
                        if(month>0 && month<13){
                            if(month==1 || month == 3 || month==5 || month==7 || month==8 || month==10 || month==12){
                                if(day>=1 && day<=31) return date;
                                else{
                                    System.out.println("Plaes try again. This month have 31 days");
                                }
                            }
                            else if(month==4 || month==6 || month==9 || month==11){
                                if(day>=1 && day<=30) return date;
                                else{
                                    System.out.println("Pleas try again. This month have 30 days");
                                }
                            }
                            else if(month==2){
                                if(day>=1 && day<=29) return date;
                                else{
                                    System.out.println("Pleas try again. This month of this year have 29 days");
                                }
                            }
                        }
                        else if(month<=0 || month>=13){
                            System.out.println("Month is wrong (from 1 to 12");
                        }
                    }
                }

                
                else if(year%4==0){
                    if(month>0 && month<13){
                        if(month==1 || month == 3 || month==5 || month==7 || month==8 || month==10 || month==12){
                            if(day>=1 && day<=31) return date;
                            else{
                                System.out.println("Plaes try again. This month have 31 days");
                            }
                        }
                        else if(month==4 || month==6 || month==9 || month==11){
                            if(day>=1 && day<=30) return date;
                            else{
                                System.out.println("Pleas try again. This month have 30 days");
                            }
                        }
                        else if(month==2){
                            if(day>=1 && day<=29) return date;
                            else{
                                System.out.println("Pleas try again. This month of this year have 29 days");
                            }
                        }
                    }
                    else if(month<=0 || month>=13){
                        System.out.println("Month is wrong (from 1 to 12)");
                    }
                }
                else{
                    if(month>0 && month<13){
                        if(month==1 || month == 3 || month==5 || month==7 || month==8 || month==10 || month==12){
                            if(day>=1 && day<=31) return date;
                            else{
                                System.out.println("Plaes try again. This month have 31 days");
                            }
                        }
                        else if(month==4 || month==6 || month==9 || month==11){
                            if(day>=1 && day<=30) return date;
                            else{
                                System.out.println("Pleas try again. This month have 30 days");
                            }
                        }
                        else if(month==2){
                            if(day>=1 && day<=28) return date;
                            else{
                                System.out.println("Pleas try again. This month of this year have 28 days");
                            }
                        }
                    }
                    else if(month<=0 || month>=13){
                        System.out.println("Month is wrong (from 1 to 12");
                    }
                }
            }
            else{
                System.out.println("Please try again (dd/mm/yyyy).");
            }
        }
    }
  public String getIDsub(String msg){
        boolean check = true;
        String ID = ""; 
        do{
            System.out.print(msg);
            ID = String.valueOf(sc.nextLine().trim().toUpperCase());
            if(ID.matches("^A-Za-z_\\s\\d{3}")){
               return ID; 
            }
            else{
                System.out.println("\n\n**Please try agian( SE and 6 digits)!!**\n\n");
                check = false;
            }
            
        }while(check==false);
        return null;
    }
 public String getChar(String msg){
        boolean check = true;
        do{
            System.out.print(msg);
            String str = String.valueOf(sc.nextLine().trim().toUpperCase());
            if(str.equals("Y") || str.equals("N")){
                return str;
            }
            
            else{
                System.out.println("\n**Please try again(\"Y\" or \"N\")!!**\n");
                check = false;
            }
        }while(check == false);
        return null;
    }

 public double getGrade(String msg){
        double number;
        while(true){
            try{
                System.out.print(msg);
                number = Double.valueOf(sc.nextLine().trim());
                if(0<number&&number<10){
                    return number;
                }
                else if(number<0){
                    System.out.println("\n\n**Must be than zero!!**\n\n");
} 
            }catch(NumberFormatException e){
                System.out.println("\n\n**Must be number not character or decimal number!**\n\n");
            }
        }
    }
}