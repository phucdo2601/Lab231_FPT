/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dto.errorObj;

/**
 *
 * @author ASUS
 */
public class UserErrorObj {
    private String userIDErr;
    private String passwordErr;
    private String confirmPassErr;
    private String emailErr;
    private String newPasswordErr;
    private String phoneErr;

    public UserErrorObj() {
    }

    public UserErrorObj(String userIDErr, String passwordErr, String confirmPassErr, String emailErr, String newPasswordErr, String phoneErr) {
        this.userIDErr = userIDErr;
        this.passwordErr = passwordErr;
        this.confirmPassErr = confirmPassErr;
        this.emailErr = emailErr;
        this.newPasswordErr = newPasswordErr;
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

    public String getConfirmPassErr() {
        return confirmPassErr;
    }

    public void setConfirmPassErr(String confirmPassErr) {
        this.confirmPassErr = confirmPassErr;
    }

    public String getEmailErr() {
        return emailErr;
    }

    public void setEmailErr(String emailErr) {
        this.emailErr = emailErr;
    }

    public String getNewPasswordErr() {
        return newPasswordErr;
    }

    public void setNewPasswordErr(String newPasswordErr) {
        this.newPasswordErr = newPasswordErr;
    }

    public String getPhoneErr() {
        return phoneErr;
    }

    public void setPhoneErr(String phoneErr) {
        this.phoneErr = phoneErr;
    }
    
}
