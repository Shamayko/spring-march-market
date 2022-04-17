package ru.shamayko.spring.march.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shamayko.spring.march.market.entities.Category;
import ru.shamayko.spring.march.market.repositories.CategoryRepository;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }


}
