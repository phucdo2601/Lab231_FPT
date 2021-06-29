/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dtos.google;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class GoogleAccDTO implements Serializable {

    private String id;
    private String email;

    public GoogleAccDTO() {
    }

    public GoogleAccDTO(String id, String email) {
        this.id = id;
        this.email = email;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

}
