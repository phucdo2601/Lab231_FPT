/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Menu extends ArrayList{

    public Menu() {
        super();
    }
    public void addMenu(String s){
        this.add(s);
    }
    
    public int getUserChoice() {
        int result = 0;
        if (this.size() > 0) {
            for (int i = 0; i < this.size(); i++) {
                System.out.println((i + 1) + "-" + this.get(i));
            }
//            do{
            try {
                System.out.println("Please select an operation: ");
                Scanner sc = new Scanner(System.in);
                result = Integer.parseInt(sc.nextLine());//get user choice
            }catch(NumberFormatException e){
                System.out.println("The Input Erorr");
            }
//            }while(result<0 || result<10);
        }
        return result;
    }
    
    /**
     * @param args the command line arguments
     */
    
    
}
