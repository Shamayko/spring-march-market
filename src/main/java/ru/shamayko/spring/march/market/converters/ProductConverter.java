package ru.shamayko.spring.march.market.converters;

import org.springframework.stereotype.Component;
import ru.shamayko.spring.march.market.dtos.ProductDto;
import ru.shamayko.spring.march.market.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {
    public ProductDto entityToDto(Product p) {
        ProductDto productDto = new ProductDto();
        productDto.setId(p.getId());
        productDto.setTitle(p.getTitle());
        productDto.setPrice(p.getPrice());
        productDto.setCategoryTitle(p.getCategory().getTitle());
        return productDto;
    }

    public List<ProductDto> productListToDtoList(List<Product> productList) {
        List<ProductDto> productDtoList = new ArrayList<>();

        for (Product p : productList
        ) {
            productDtoList.add(entityToDto(p));
        }

        return productDtoList;
    }

}
