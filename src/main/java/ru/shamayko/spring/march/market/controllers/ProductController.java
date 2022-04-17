package ru.shamayko.spring.march.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.shamayko.spring.march.market.converters.ProductConverter;
import ru.shamayko.spring.march.market.dtos.ProductDto;
import ru.shamayko.spring.march.market.exceptions.ResourceNotFoundException;
import ru.shamayko.spring.march.market.services.ProductService;


import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductConverter productConverter;

    @GetMapping("")
    public List<ProductDto> getAllProducts(){
        return productConverter.productListToDtoList(productService.findAll());
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewProduct(@RequestBody ProductDto productDto) {
        productService.createNewProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productConverter.entityToDto(productService.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Продукт с id: " + id + " не найден")));
    }


}
