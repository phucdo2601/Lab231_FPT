/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0003;

/**
 *
 * @author ASUS
 */
public class Product implements Comparable{
    String idProduct, nameProduct, date, nationality;
    double price;
    int quantity;
    Category cat;

    public Product() {
    }

    public Product(String idProduct, String nameProduct, String date, String nationality, double price, int quantity, Category cat) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.date = date;
        this.nationality = nationality;
        this.price = price;
        this.quantity = quantity;
        this.cat = cat;
    }

    

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    @Override
    public int compareTo(Object product) {
        return this.getIdProduct().compareTo(((Product)product).getIdProduct());
    }
    
}