package com.giodefa.petshops.service.category;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.giodefa.petshops.exceptions.AlreadyExistsException;
import com.giodefa.petshops.exceptions.ResourceNotFoundException;
import com.giodefa.petshops.model.Category;
import com.giodefa.petshops.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
       return Optional.of(category).filter(c -> !categoryRepository.existsByName(c.getName()))
        .map(categoryRepository :: save)
        .orElseThrow(() -> new AlreadyExistsException(category.getName() + " already exists!"));
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.findById(id)
            .ifPresentOrElse(categoryRepository::delete, () -> {
                throw new ResourceNotFoundException("Category Not Found");
            });
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        // TODO Auto-generated method stub
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        return Optional.ofNullable(getCategoryById(id)).map(oldCategory -> {
            oldCategory.setName(category.getName());
            return categoryRepository.save(oldCategory);
        }).orElseThrow(() -> new ResourceNotFoundException("Category not Found!"));
    }

}
