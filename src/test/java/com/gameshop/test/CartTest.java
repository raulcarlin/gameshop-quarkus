package com.gameshop.test;

import com.gameshop.model.Cart;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class CartTest {

    @Inject
    CartServiceMock cartServiceMock;

    @Test
    public void testAddItem() {
        Cart cart = cartServiceMock.addItem(1l, null);
        Assertions.assertEquals(cart.quantity, 1);
        Assertions.assertEquals(cart.itens.size(), 1);
    }

    @Test
    public void testRestCarts() {
        given()
            .when().get("/carts")
            .then()
            .statusCode(200)
            .body(is("{}"));
    }

}
