package ru.shamayko.spring.march.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shamayko.spring.march.market.dtos.ProductDto;
import ru.shamayko.spring.march.market.entities.Product;
import ru.shamayko.spring.march.market.exceptions.ResourceNotFoundException;
import ru.shamayko.spring.march.market.repositories.ProductRepository;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;


    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void createNewProduct(ProductDto productDto) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setCategory(categoryService.findByTitle(productDto.getCategoryTitle()).
                orElseThrow(() -> new ResourceNotFoundException("Категория с названием: " + productDto.getCategoryTitle() + " не найдена")));
        productRepository.save(product);
    }


    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

}
