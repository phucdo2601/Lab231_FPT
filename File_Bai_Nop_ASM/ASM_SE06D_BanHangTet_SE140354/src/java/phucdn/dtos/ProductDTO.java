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
public class ProductDTO {

    private String productID;
    private String categoryID;
    private String productName;
    private String image;
    private String description;
    private double price;
    private int quantity;
    private int sale;
    private String unit;
    private Timestamp dateOfPost;
    private boolean status;

    public ProductDTO(String productID, String categoryID, String productName, String image, String description, double price, int quantity, int sale, String unit, Timestamp dateOfPost, boolean status) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.sale = sale;
        this.unit = unit;
        this.dateOfPost = dateOfPost;
        this.status = status;
    }

    public ProductDTO(String productID, String categoryID, String productName, String image, String description, double price, int quantity, int sale) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.sale = sale;
    }

    public ProductDTO(String productID, String categoryID, String productName, String image, String description, double price, int quantity, int sale, String unit, boolean status) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.sale = sale;
        this.unit = unit;
        this.status = status;
    }

    public ProductDTO(String productID, String categoryID, String productName, String description, int quantity, double price, int sale, String unit) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.sale = sale;
        this.unit = unit;
    }

    public ProductDTO(String productID, String categoryID, String productName, String image, double price, String unit, Timestamp dateOfPost, int quantity) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.image = image;
        this.price = price;
        this.unit = unit;
        this.dateOfPost = dateOfPost;
        this.quantity = quantity;
    }

    public ProductDTO() {
    }

    public ProductDTO(String productID, boolean status) {
        this.productID = productID;
        this.status = status;
    }

    public ProductDTO(String productID, int quantity) {
        this.productID = productID;
        this.quantity = quantity;
    }

    public ProductDTO(String productID, String productName, String image, double price) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Timestamp getDateOfPost() {
        return dateOfPost;
    }

    public void setDateOfPost(Timestamp dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
