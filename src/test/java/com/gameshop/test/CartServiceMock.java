package com.gameshop.test;

import com.gameshop.model.Cart;
import com.gameshop.model.Item;
import com.gameshop.service.CartService;
import io.quarkus.test.Mock;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@Mock
@ApplicationScoped
public class CartServiceMock extends CartService {

    @Override
    public Cart addItem(Long cartId, Item item) {
        Cart cart = new Cart();
        cart.id = cartId;
        cart.userName = "test";

        item = new Item();
        item.id = 1l;
        item.type = "Game";
        item.value = BigDecimal.valueOf(10.50);

        cart.quantity = 1;
        cart.itens.add(item);

        return cart;
    }
}
