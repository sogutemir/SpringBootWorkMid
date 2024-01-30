package org.work.springbootwork.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.work.springbootwork.core.results.DataResult;
import org.work.springbootwork.core.results.Result;
import org.work.springbootwork.dto.CategoryDTO;
import org.work.springbootwork.dto.CustomerDTO;
import org.work.springbootwork.service.concretes.CategoryService;
import org.work.springbootwork.utils.ResponseUtil;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<CategoryDTO>>> getAllCustomer(){
        return ResponseUtil.buildDataResultResponse(categoryService.getAllCategory());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<DataResult<CategoryDTO>> getCustomerById(@PathVariable Long id){
        return ResponseUtil.buildDataResultResponse(categoryService.getCategoryById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Result> addCustomer(@RequestBody CategoryDTO categoryDTO){
        return ResponseUtil.buildResultResponse(categoryService.addCategory(categoryDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Result> updateCustomer(@RequestBody CategoryDTO categoryDTO, @PathVariable Long id){
        return ResponseUtil.buildResultResponse(categoryService.updateCategory(categoryDTO, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Result> deleteCustomer(@PathVariable Long id){
        return ResponseUtil.buildResultResponse(categoryService.deleteCategory(id));
    }
}
