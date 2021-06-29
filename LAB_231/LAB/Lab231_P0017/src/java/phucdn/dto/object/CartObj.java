/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dto.object;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class CartObj implements Serializable{

    private String username;
    private HashMap<String, UserDTO> cart;

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

    public HashMap<String, UserDTO> getCart() {
        return cart;
    }

    public void setCart(HashMap<String, UserDTO> cart) {
        this.cart = cart;
    }

    public void addToCart(UserDTO dto) throws Exception {
//        if (this.cart.containsKey(dto.getUserID())) {
//            dto.setRankPromo(5);
//        }
        this.cart.put(dto.getUserID(), dto);
    }

    public void remove(String id) throws Exception {
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }

    public void update(String id, int quantity) throws Exception {
        if (this.cart.containsKey(id)) {
            this.cart.get(id).setRankPromo(this.cart.get(id).getRankPromo() + quantity);
        }
    }

    public void decrease(String id, int quantity) throws Exception {
        if (this.cart.containsKey(id)) {
            this.cart.get(id).setRankPromo(this.cart.get(id).getRankPromo() - quantity);
        }
    }

}
