package org.work.springbootwork.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.work.springbootwork.core.results.DataResult;
import org.work.springbootwork.core.results.ErrorDataResult;
import org.work.springbootwork.core.results.Result;
import org.work.springbootwork.core.results.SuccessDataResult;
import org.work.springbootwork.dto.ProductDTO;
import org.work.springbootwork.service.concretes.ProductService;
import org.work.springbootwork.utils.ResponseUtil;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<ProductDTO>>> getAllProduct(){
        return ResponseUtil.buildDataResultResponse(productService.getAllProduct());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<DataResult<ProductDTO>> getProductById(@PathVariable Long id){
        return ResponseUtil.buildDataResultResponse(productService.getProductById(id));
    }

    @GetMapping("/getbycategoryid/{id}")
    public ResponseEntity<DataResult<List<ProductDTO>>> getProductByCategoryId(@PathVariable Long id){
        return ResponseUtil.buildDataResultResponse(productService.findByCategoryId(id));
    }

    public ResponseEntity<DataResult<List<ProductDTO>>> getProductByContainsName(@PathVariable String name){
        return ResponseUtil.buildDataResultResponse(productService.findByNameContaining(name));
    }

    @PostMapping("/add")
    public ResponseEntity<Result> addProduct(@RequestBody ProductDTO productDTO){
        return ResponseUtil.buildResultResponse(productService.addProduct(productDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Result> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Long id){
        return ResponseUtil.buildResultResponse(productService.updateProduct(productDTO, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Result> deleteProduct(@PathVariable Long id){
        return ResponseUtil.buildResultResponse(productService.deleteProduct(id));
    }
}
