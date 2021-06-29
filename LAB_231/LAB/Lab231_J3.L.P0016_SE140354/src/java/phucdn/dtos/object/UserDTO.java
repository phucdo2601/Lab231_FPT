package phucdn.dtos.object;

import java.io.Serializable;
import java.sql.Timestamp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class UserDTO implements Serializable{
    private String userID;
    private String password;
    private String fullname;
    private String address;
    private Timestamp createDate;
    private String role;
    private String status;
    private String phoneNumber;

    public UserDTO() {
    }

    public UserDTO(String userID, String password, String fullname, String address, Timestamp createDate, String role, String phoneNumber) {
        this.userID = userID;
        this.password = password;
        this.fullname = fullname;
        this.address = address;
        this.createDate = createDate;
        this.role = role;
        this.phoneNumber = phoneNumber;
    }

    public UserDTO(String userID, String password, String fullname, String address, Timestamp createDate, String role, String status, String phoneNumber) {
        this.userID = userID;
        this.password = password;
        this.fullname = fullname;
        this.address = address;
        this.createDate = createDate;
        this.role = role;
        this.status = status;
        this.phoneNumber = phoneNumber;
    }
    
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
