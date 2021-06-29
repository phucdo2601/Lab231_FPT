/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dtos.object;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class CategoryDTO implements Serializable{
    private String cateID;
    private String cateName;
    private String roleBorrow;
    private String description;

    public CategoryDTO() {
    }

    public CategoryDTO(String cateID, String cateName, String roleBorrow, String description) {
        this.cateID = cateID;
        this.cateName = cateName;
        this.roleBorrow = roleBorrow;
        this.description = description;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getRoleBorrow() {
        return roleBorrow;
    }

    public void setRoleBorrow(String roleBorrow) {
        this.roleBorrow = roleBorrow;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
