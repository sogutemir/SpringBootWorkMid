package org.work.springbootwork.service.concretes;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.work.springbootwork.core.results.*;
import org.work.springbootwork.dto.CategoryDTO;
import org.work.springbootwork.model.Category;
import org.work.springbootwork.repository.CategoryRepository;
import org.work.springbootwork.service.abstracts.ICategoryService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public DataResult<List<CategoryDTO>> gettAllCategory() {
        List<Category> category = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = category.stream()
                .map(category1 -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(categoryDTOS, "Category Listed");
    }

    @Override
    public DataResult<CategoryDTO> getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if(category == null){
            return new ErrorDataResult<>(null, "Category not found");
        }
        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
        return new SuccessDataResult<>(categoryDTO, "Category Listed");
    }

    @Override
    public Result addCategory(CategoryDTO categoryDTO) {
        if(categoryDTO == null){
            return new ErrorResult("Category not found");
        }
        Category category = modelMapper.map(categoryDTO, Category.class);
        categoryRepository.save(category);
        return new SuccessResult("Category added");
    }

    @Override
    public Result updateCategory(CategoryDTO categoryDTO, Long id) {
        if(categoryDTO == null){
            return new ErrorResult("Category not found");
        }
        Category existCategory = categoryRepository.findById(id).
                orElse(null);
        if(existCategory == null){
            return new ErrorResult("Category not found");
        }
        modelMapper.map(categoryDTO, existCategory);
        categoryRepository.save(existCategory);
        return new SuccessResult("Category updated");
    }

    @Override
    public Result deleteCategory(Long id) {
        if(!categoryRepository.existsById(id)){
            return new ErrorResult("Category not found");
        }
        categoryRepository.deleteById(id);
        return new SuccessResult("Category deleted");
    }
}
