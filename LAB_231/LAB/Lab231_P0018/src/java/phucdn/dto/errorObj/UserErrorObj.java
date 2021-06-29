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

    public UserErrorObj() {
    }

    public UserErrorObj(String userIDErr, String passwordErr) {
        this.userIDErr = userIDErr;
        this.passwordErr = passwordErr;
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
    
}
