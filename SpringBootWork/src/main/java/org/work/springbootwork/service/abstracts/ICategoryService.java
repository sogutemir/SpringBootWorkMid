package org.work.springbootwork.service.abstracts;

import org.work.springbootwork.core.results.DataResult;
import org.work.springbootwork.core.results.Result;
import org.work.springbootwork.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    DataResult<List<CategoryDTO>> getAllCategory();
    DataResult<CategoryDTO> getCategoryById(Long id);
    Result addCategory(CategoryDTO categoryDTO);
    Result updateCategory(CategoryDTO categoryDTO, Long id);
    Result deleteCategory(Long id);

}
