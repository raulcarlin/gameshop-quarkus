package com.gameshop.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String userName;
    public Integer quantity;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cart_itens")
    public List<Item> itens;

    public static List<Cart> findForUser(String userName) {
        return Cart.find("FROM Cart c WHERE c.userName = ?1", userName).list();
    }

}
