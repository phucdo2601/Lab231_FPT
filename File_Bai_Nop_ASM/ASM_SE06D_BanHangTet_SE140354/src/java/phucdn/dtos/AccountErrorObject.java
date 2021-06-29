/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dtos;

/**
 *
 * @author phucd
 */
public class AccountErrorObject {
    private String usernameError;
    private String passwordError;
    private String fullnameError;
    private String confirmError;
    private String usernameisExisted;

    public AccountErrorObject() {
    }

    public AccountErrorObject(String usernameError, String passwordError) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
    }

    public AccountErrorObject(String usernameError, String passwordError, String fullnameError, String confirmError, String usernameisExisted) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.fullnameError = fullnameError;
        this.confirmError = confirmError;
        this.usernameisExisted = this.usernameisExisted;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getFullnameError() {
        return fullnameError;
    }

    public void setFullnameError(String fullnameError) {
        this.fullnameError = fullnameError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getUsernameisExisted() {
        return usernameisExisted;
    }

    public void setUsernameisExisted(String usernameisExisted) {
        this.usernameisExisted = usernameisExisted;
    }
    
}
