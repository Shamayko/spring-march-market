package ru.shamayko.spring.march.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shamayko.spring.march.market.converters.CartConverter;
import ru.shamayko.spring.march.market.dtos.CartDto;
import ru.shamayko.spring.march.market.services.CartService;
import ru.shamayko.spring.march.market.utils.Cart;


@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final CartConverter cartConverter;

    @GetMapping("")
    public CartDto getCurrentCartDto(Cart cart) {
        return cartConverter.getCartDto(cartService.getCurrentCart());
    }


    @GetMapping("/add/{productId}")
    public void addProductToCart(@PathVariable Long productId) {
        cartService.addToCart(productId);
    }

    @GetMapping("/remove/{id}")
    public void minusProductFromCart(@PathVariable Long id) {
        cartService.removeById(id);
    }

    @GetMapping("/clear")
    public void clearCart() {
        cartService.clearCart();

    }
}
