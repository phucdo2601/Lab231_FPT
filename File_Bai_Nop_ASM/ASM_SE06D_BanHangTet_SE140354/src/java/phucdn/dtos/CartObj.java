/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dtos;

import java.util.HashMap;

/**
 *
 * @author phucd
 */
public class CartObj {

    private String username;

    private HashMap<String, ProductDTO> cart;

    public CartObj() {
        this.username = "GUEST";
        this.cart = new HashMap<>();
    }

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

    public HashMap<String, ProductDTO> getCart() {
        return cart;
    }
    
    public void AddToCart(ProductDTO dto) throws Exception{
        if (this.cart.containsKey(dto.getProductID())) {
            int quantity = this.cart.get(dto.getProductID()).getQuantity() + 1;
            dto.setQuantity(quantity);
        }
        this.cart.put(dto.getProductID(), dto);
    }
    
    public void remove(String id) throws Exception{
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }
    public void update(String id, int quantity) throws Exception{
        if (this.cart.containsKey(id)) {
            this.cart.get(id).setQuantity(quantity);
        }
    }
    
    public double getTotal() throws Exception{
        double result = 0;
        for(ProductDTO dto: this.cart.values()){
            result += dto.getPrice() * dto.getQuantity();
        }
        return result;
    }
}
