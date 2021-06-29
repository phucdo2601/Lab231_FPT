/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dtos;

import java.sql.Timestamp;

/**
 *
 * @author phucd
 */
public class AccountDTO {
    private String username;
    private String password;
    private String fullname;
    private String address;
    private String phone;
    private String email;
    private String roleID;
    private boolean status;
    private Timestamp dateOfPost;

    public AccountDTO() {
    }

    public AccountDTO(String username, boolean status) {
        this.username = username;
        this.status = status;
    }

    public AccountDTO(String username, String password, String fullname, String address, String phone, String email, String roleID, boolean status, Timestamp dateOfPost) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.roleID = roleID;
        this.status = status;
        this.dateOfPost = dateOfPost;
    }

    public AccountDTO(String username, String password, String fullname, String address, String phone, String email, String roleID, boolean status) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.roleID = roleID;
        this.status = status;
    }
    
    public AccountDTO(String username, String fullname, String address, String phone, String email) {
        this.username = username;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public AccountDTO(String username, String fullname, String address, String phone, String email, boolean status) {
        this.username = username;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public AccountDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getDateOfPost() {
        return dateOfPost;
    }

    public void setDateOfPost(Timestamp dateOfPost) {
        this.dateOfPost = dateOfPost;
    }
}
