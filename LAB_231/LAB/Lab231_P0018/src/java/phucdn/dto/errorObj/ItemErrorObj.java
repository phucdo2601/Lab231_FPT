/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dto.errorObj;

/**
 *
 * @author ASUS
 */
public class ItemErrorObj {
    private String itemIDErr;
    private String itemNameErr;
    private String authorErr;
    private String cateIDErr;
    private String quantityErr;
    private String priceErr;

    public ItemErrorObj() {
    }

    public ItemErrorObj(String itemIDErr, String itemNameErr, String authorErr, String cateIDErr, String quantityErr, String priceErr) {
        this.itemIDErr = itemIDErr;
        this.itemNameErr = itemNameErr;
        this.authorErr = authorErr;
        this.cateIDErr = cateIDErr;
        this.quantityErr = quantityErr;
        this.priceErr = priceErr;
    }

    public String getItemIDErr() {
        return itemIDErr;
    }

    public void setItemIDErr(String itemIDErr) {
        this.itemIDErr = itemIDErr;
    }

    public String getItemNameErr() {
        return itemNameErr;
    }

    public void setItemNameErr(String itemNameErr) {
        this.itemNameErr = itemNameErr;
    }

    public String getAuthorErr() {
        return authorErr;
    }

    public void setAuthorErr(String authorErr) {
        this.authorErr = authorErr;
    }

    public String getCateIDErr() {
        return cateIDErr;
    }

    public void setCateIDErr(String cateIDErr) {
        this.cateIDErr = cateIDErr;
    }

    public String getQuantityErr() {
        return quantityErr;
    }

    public void setQuantityErr(String quantityErr) {
        this.quantityErr = quantityErr;
    }

    public String getPriceErr() {
        return priceErr;
    }

    public void setPriceErr(String priceErr) {
        this.priceErr = priceErr;
    }
}
