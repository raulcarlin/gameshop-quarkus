package com.gameshop.resource;

import com.gameshop.model.Cart;
import com.gameshop.model.Item;
import com.gameshop.service.CartService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/carts")
@Produces(MediaType.APPLICATION_JSON)
public class CartResource {

    @GET
    public List<Cart> getCartInfo() {
        return Cart.findForUser("test");
    }

    @Transactional
    @POST
    @Path("/item")
    public Cart addItem(@QueryParam("cartId") Long cartId, Item item) {
        return cartService.addItem(cartId, item);
    }

    @Inject
    private CartService cartService;
}
