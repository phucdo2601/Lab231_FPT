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
public class CategoryErrorObject {
    private String categoryIDError;
    private String categoryNameError;
    private String categoryDescriptionError;
    private String categoryIDisExsited;

    public CategoryErrorObject() {
    }

    public CategoryErrorObject(String categoryIDError, String categoryNameError, String categoryDescriptionError, String categoryIDisExsited) {
        this.categoryIDError = categoryIDError;
        this.categoryNameError = categoryNameError;
        this.categoryDescriptionError = categoryDescriptionError;
        this.categoryIDisExsited = categoryIDisExsited;
    }

    public String getCategoryIDError() {
        return categoryIDError;
    }

    public void setCategoryIDError(String categoryIDError) {
        this.categoryIDError = categoryIDError;
    }

    public String getCategoryNameError() {
        return categoryNameError;
    }

    public void setCategoryNameError(String categoryNameError) {
        this.categoryNameError = categoryNameError;
    }

    public String getCategoryDescriptionError() {
        return categoryDescriptionError;
    }

    public void setCategoryDescriptionError(String categoryDescriptionError) {
        this.categoryDescriptionError = categoryDescriptionError;
    }

    public String getCategoryIDisExsited() {
        return categoryIDisExsited;
    }

    public void setCategoryIDisExsited(String categoryIDisExsited) {
        this.categoryIDisExsited = categoryIDisExsited;
    }

}
