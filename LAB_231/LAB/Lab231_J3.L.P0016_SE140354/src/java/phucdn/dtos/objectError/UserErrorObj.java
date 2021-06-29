/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dtos.objectError;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class UserErrorObj implements Serializable{
    private String userIDErr;
    private String passwordErr;
    private String confirmPasswordErr;
    private String fullnameErr;
    private String addressErr;
    private String phoneErr;

    public UserErrorObj() {
    }

    public UserErrorObj(String userIDErr, String passwordErr, String confirmPasswordErr, String fullnameErr, String addressErr, String phoneErr) {
        this.userIDErr = userIDErr;
        this.passwordErr = passwordErr;
        this.confirmPasswordErr = confirmPasswordErr;
        this.fullnameErr = fullnameErr;
        this.addressErr = addressErr;
        this.phoneErr = phoneErr;
    }

    public String getUserIDErr() {
        return userIDErr;
    }

    public void setUserIDErr(String userIDErr) {
        this.userIDErr = userIDErr;
    }

    public String getPasswordErr() {
        return passwordErr;
    }

    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    public String getConfirmPasswordErr() {
        return confirmPasswordErr;
    }

    public void setConfirmPasswordErr(String confirmPasswordErr) {
        this.confirmPasswordErr = confirmPasswordErr;
    }

    public String getFullnameErr() {
        return fullnameErr;
    }

    public void setFullnameErr(String fullnameErr) {
        this.fullnameErr = fullnameErr;
    }

    public String getAddressErr() {
        return addressErr;
    }

    public void setAddressErr(String addressErr) {
        this.addressErr = addressErr;
    }

    public String getPhoneErr() {
        return phoneErr;
    }

    public void setPhoneErr(String phoneErr) {
        this.phoneErr = phoneErr;
    }
    
}
