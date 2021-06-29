/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputbooleandatevalues;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author ASUS
 */
public class BooleanDateDemo {
    public static boolean isLeap(int y){
        boolean result = false;
        if((y%400==0) || (y%4==0) && (y%100!=0)) return true;
        return false;
    }
    
    public static boolean valid(int y, int m, int d){
        if(y<0 || m<0 || d<0|| d>31) return false;
        int maxD =31;
        if(m == 4 || m ==6 || m ==9 || m == 11 ){
            maxD = 30;
        }
        else if(m == 2){
            if (isLeap(y)) {
                maxD = 29;
            }
            else maxD = 28;
        }
        return d <= maxD;
    }
    public static long toDate(String ymd){
        StringTokenizer stk = new StringTokenizer(ymd, "/-");
        int y = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken());
        if (!valid(y, m, d)) {
            return -1;
        }
        Calendar cal =  Calendar.getInstance();
        cal.set(y, m-1, d);
        long t = cal.getTime().getTime();
        return  t;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr;
        boolean b = true;
        
        System.out.println("Input a boolean value- T/F");
        inputStr = sc.nextLine().trim().toUpperCase();
        if(inputStr.startsWith("T")) b = true;
        else b = false;
        System.out.println("Inputted boolean value: "+b);
        Date d = new Date(System.currentTimeMillis());
        System.out.println("Current date: " +d);
        System.out.println("Input a date value yyyy/d/m: ");
        inputStr = sc.nextLine().trim();
        long t = toDate(inputStr);
        if(t<0) System.out.println("Inputted date is invalid!");
        else{
            d = new Date(t);
            System.out.println("Inputted date: " +d);
        }
    }
}
