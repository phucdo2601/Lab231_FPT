/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0003;

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
    
    public int getUserChoice(){
        int result = 0;
        if (this.size() > 0) {
            for (int i = 0; i < this.size(); i++) {
                System.out.println((i+1)+"-"+this.get(i));
            }
            try {
                System.out.print("Please select an operation: ");
                Scanner sc = new Scanner(System.in);
                result = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("The Input Erorr!");
            }
        }
        return result;
    }
}
