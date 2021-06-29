/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dto.object;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class PromoStatusDTO implements Serializable{
    private String promoStatusID;
    private String promoStatusName;

    public PromoStatusDTO() {
    }

    public PromoStatusDTO(String promoStatusID, String promoStatusName) {
        this.promoStatusID = promoStatusID;
        this.promoStatusName = promoStatusName;
    }

    public String getPromoStatusID() {
        return promoStatusID;
    }

    public void setPromoStatusID(String promoStatusID) {
        this.promoStatusID = promoStatusID;
    }

    public String getPromoStatusName() {
        return promoStatusName;
    }

    public void setPromoStatusName(String promoStatusName) {
        this.promoStatusName = promoStatusName;
    }
    
}
