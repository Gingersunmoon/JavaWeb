package com.test;

import com.pojo.Cart;
import com.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

public class CartTest {
    Cart cart=new Cart();
    @Test
    public void addItem() {
        cart.addItem(new CartItem(1,"JAVA",1,new BigDecimal(90),new BigDecimal(90)));
        cart.addItem(new CartItem(2,"C++",1,new BigDecimal(60),new BigDecimal(60)));
        cart.addItem(new CartItem(2,"C++",1,new BigDecimal(60),new BigDecimal(60)));
        cart.addItem(new CartItem(3,"PYTHON",1,new BigDecimal(30),new BigDecimal(30)));
        cart.deleteItem(3);
        cart.updateItem(2,5);
        cart.clear();
        System.out.println(cart.toString());
    }

    @Test
    public void deleteItem() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void updateItem() {
    }

    @Test
    public void testToString() {
    }
}