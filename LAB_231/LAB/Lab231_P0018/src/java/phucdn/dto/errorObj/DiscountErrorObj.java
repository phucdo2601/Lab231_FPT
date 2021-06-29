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
public class DiscountErrorObj {
    private String discountIDErr;
    private String rateDisErr;

    public DiscountErrorObj() {
    }

    public DiscountErrorObj(String discountIDErr, String rateDisErr) {
        this.discountIDErr = discountIDErr;
        this.rateDisErr = rateDisErr;
    }

    public String getDiscountIDErr() {
        return discountIDErr;
    }

    public void setDiscountIDErr(String discountIDErr) {
        this.discountIDErr = discountIDErr;
    }

    public String getRateDisErr() {
        return rateDisErr;
    }

    public void setRateDisErr(String rateDisErr) {
        this.rateDisErr = rateDisErr;
    }
}
