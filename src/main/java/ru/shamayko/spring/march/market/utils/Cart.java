package ru.shamayko.spring.march.market.utils;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.shamayko.spring.march.market.entities.Product;

import java.util.List;

@Component
@Data
public class Cart {
    private List<Product> products;

    public void add(Product p) {

        products.add(p);
    }
    public List<Product> getAllCart(){
        return products;
    }
}


