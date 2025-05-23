package com.gpms.backend.services.Category.service.Impl;

import com.gpms.backend.entity.Category;
import com.gpms.backend.services.Category.repoisitory.CategoryRepository;
import com.gpms.backend.services.Category.service.categoryValidation.CategoryService;
import com.gpms.backend.services.Category.service.mapper.CategoryRequestToCategoryMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
//    private final CategoryRequestToCategoryMapper categoryRequestToCategoryMapper;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return Optional.empty();
    }
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Integer id) {

    }



}
