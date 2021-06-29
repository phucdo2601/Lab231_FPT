/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.MyUntil;

/**
 *
 * @author ASUS
 */
public class Menu extends ArrayList{
    int choice;
    MyUntil myUntil = new MyUntil();
    Scanner sc = new Scanner(System.in);
    public int getUserChoice(){
        System.out.println("=====================================Options===========================================");
        for(int i=0;i<this.size();i++){
            System.out.println("\t\t" + (i+1) + ". " + this.get(i));
        }
        choice = myUntil.getIntNumber("Choose your option: ");
        return choice;
    }
}


 
    

