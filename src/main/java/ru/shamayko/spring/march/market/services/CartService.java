
package ru.shamayko.spring.march.market.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.shamayko.spring.march.market.entities.Product;

import java.util.List;


@Service
@Data
@AllArgsConstructor
public class CartService {
    private final ProductService productService;
    private List<Product> productList;

    public Product addToCart(Long id) {
        Product product = productService.findById(id);
        productList.add(product);
        return product;
    }

    public List<Product> showCartService() {
        return productList;
    }


}