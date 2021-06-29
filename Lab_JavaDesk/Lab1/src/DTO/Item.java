/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class Item {
    public String itemCode, itemName, unit;
    public double price;
    public boolean supplying;
    public String supCode;

    public Item() {
    }

    public Item(String itemCode, String itemName, String unit, double price, boolean supplying, String supCode) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unit = unit;
        this.price = price;
        this.supplying = supplying;
        this.supCode = supCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSupplying() {
        return supplying;
    }

    public void setSupplying(boolean supplying) {
        this.supplying = supplying;
    }

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }

    @Override
    public String toString() {
        return "Item{" + "itemCode=" + itemCode + ", itemName=" + itemName + ", unit=" + unit + ", price=" + price + ", supplying=" + supplying + ", supCode=" + supCode + '}';
    }
    
}
