package ru.shamayko.spring.march.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shamayko.spring.march.market.entities.Product;
import ru.shamayko.spring.march.market.services.CartService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping("")
    public List<Product> showCartController() {return cartService.showCartService();
    }

    @GetMapping("/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.addToCart(id);
    }
}