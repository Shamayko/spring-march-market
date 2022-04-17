
package ru.shamayko.spring.march.market.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shamayko.spring.march.market.entities.Product;
import ru.shamayko.spring.march.market.exceptions.ResourceNotFoundException;
import ru.shamayko.spring.march.market.utils.Cart;

import javax.annotation.PostConstruct;
import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductService productService;
    private Cart cart;

    @PostConstruct
    public void init() {
        cart = new Cart();
        cart.setItems(new ArrayList<>());
    }

    public Cart getCurrentCart() {
        return cart;
    }

    public void addToCart(Long productId) {
        Product p = productService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Продукт с id: " + productId + " не найден"));
        cart.add(p);
    }

    public void removeById(Long id) {
        cart.deleteProductFormCart(id);
    }

    public void clearCart() {
        cart.clear();
    }
}