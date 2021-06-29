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
public class ProductErrorObject {
    private String productIDError;
    private String categoryIDError;
    private String productNameError;
    private String descrptionError;
    private String imageError;
    private String priceError;
    private String quantityError;
    private String saleError;
    private String unitError;
    private String productIDIsExisted;

    public ProductErrorObject() {
    }

    public ProductErrorObject(String productIDError, String categoryIDError, String productNameError, String descrptionError, String imageError, String priceError, String quantityError, String saleError, String unitError, String productIDIsExisted) {
        this.productIDError = productIDError;
        this.categoryIDError = categoryIDError;
        this.productNameError = productNameError;
        this.descrptionError = descrptionError;
        this.imageError = imageError;
        this.priceError = priceError;
        this.quantityError = quantityError;
        this.saleError = saleError;
        this.unitError = unitError;
        this.productIDIsExisted = productIDIsExisted;
    }

    public String getProductIDError() {
        return productIDError;
    }

    public void setProductIDError(String productIDError) {
        this.productIDError = productIDError;
    }

    public String getCategoryIDError() {
        return categoryIDError;
    }

    public void setCategoryIDError(String categoryIDError) {
        this.categoryIDError = categoryIDError;
    }

    public String getProductNameError() {
        return productNameError;
    }

    public void setProductNameError(String productNameError) {
        this.productNameError = productNameError;
    }

    public String getDescrptionError() {
        return descrptionError;
    }

    public void setDescrptionError(String descrptionError) {
        this.descrptionError = descrptionError;
    }

    public String getImageError() {
        return imageError;
    }

    public void setImageError(String imageError) {
        this.imageError = imageError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    public String getSaleError() {
        return saleError;
    }

    public void setSaleError(String saleError) {
        this.saleError = saleError;
    }

    public String getUnitError() {
        return unitError;
    }

    public void setUnitError(String unitError) {
        this.unitError = unitError;
    }

    public String getProductIDIsExisted() {
        return productIDIsExisted;
    }

    public void setProductIDIsExisted(String productIDIsExisted) {
        this.productIDIsExisted = productIDIsExisted;
    }
    
}
