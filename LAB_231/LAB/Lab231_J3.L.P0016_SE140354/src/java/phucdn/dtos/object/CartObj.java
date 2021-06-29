/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dtos.object;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class CartObj implements Serializable{
    private String username;
    private HashMap<String, ItemDTO> cart;

    public CartObj(String username) {
        this.username = username;
        this.cart = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HashMap<String, ItemDTO> getCart() {
        return cart;
    }

    public void setCart(HashMap<String, ItemDTO> cart) {
        this.cart = cart;
    }
    
    public void addToCart(ItemDTO dto) throws Exception{
        if (this.cart.containsKey(dto.getItemID())) {
            int quantity = this.cart.get(dto.getItemID()).getQuantity() + 1;
            dto.setQuantity(quantity);
        }
        this.cart.put(dto.getItemID(), dto);
    }
    
    public void remove(String id) throws Exception{
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }
    
    public void update(String id, int quantity) throws Exception{
        if (this.cart.containsKey(id)) {
            this.cart.get(id).setQuantity(this.cart.get(id).getQuantity() + quantity);
        }
    }
    
    public void decrease(String id, int quantity) throws Exception{
        if (this.cart.containsKey(id)) {
            this.cart.get(id).setQuantity(this.cart.get(id).getQuantity() - quantity);
        }
    }
}
