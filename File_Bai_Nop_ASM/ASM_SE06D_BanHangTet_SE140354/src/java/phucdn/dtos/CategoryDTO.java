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
public class CategoryDTO {

    private String categoryID;
    private String categoryName;
    private String description;
    private boolean status;
    private Timestamp dateOfPost;

    public CategoryDTO() {
    }

    public CategoryDTO(String categoryID, boolean status) {
        this.categoryID = categoryID;
        this.status = status;
    }

    public CategoryDTO(String categoryID, String categoryName, String description, boolean status, Timestamp dateOfPost) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.description = description;
        this.status = status;
        this.dateOfPost = dateOfPost;
    }
    
    public CategoryDTO(String categoryID, String categoryName, String description, boolean status) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.description = description;
        this.status = status;
    }

    public CategoryDTO(String categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
