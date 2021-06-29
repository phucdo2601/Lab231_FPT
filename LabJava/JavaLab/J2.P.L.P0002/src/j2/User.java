/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2;

/**
 *
 * @author ASUS
 */
public class User implements Comparable{
    public String username, firstName, lastName, password, confirm, phone, email;

    public User() {
    }

    public User(String username, String firstName, String lastName, String password, String confirm, String phone, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.confirm = confirm;
        this.phone = phone;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void print(){
        System.out.println("The username of account: " +username);
        System.out.println("The name of account: " +lastName+" "+firstName);
        System.out.println("The password of account: "+password);
        System.out.println("The confirm password of account: "+confirm);
        System.out.println("The phone number of account: "+phone);
        System.out.println("The email of account: "+email);
    }

    @Override
    public int compareTo(Object us) {
        return this.getUsername().compareTo(((User)us).getUsername());
    }
}
