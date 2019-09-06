package com.gameshop.service;

import com.gameshop.model.Cart;
import com.gameshop.model.Item;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class CartService {

    public Cart addItem(Long cartId, Item item) {
        Cart cart = (cartId == null) ? createCart() : Cart.findById(cartId);

        if(cart.itens == null) {
            cart.itens = new ArrayList<>();
        }

        if(item.id == null) {
            item.persist();
        }

        cart.itens.add(item);
        cart.quantity++;

        cart.persist();

        return cart;
    }

    private Cart createCart() {
        Cart cart = new Cart();

        cart.userName = "test";
        cart.quantity = 0;

        cart.persist();

        return cart;
    }

}
