package org.work.springbootwork.service.concretes;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.work.springbootwork.core.results.*;
import org.work.springbootwork.dto.ProductDTO;
import org.work.springbootwork.model.Product;
import org.work.springbootwork.repository.ProductRepository;
import org.work.springbootwork.service.abstracts.IProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public DataResult<List<ProductDTO>> getAllProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(java.util.stream.Collectors.toList());
        return new SuccessDataResult<>(productDTOS, "Product Listed");
    }

    @Override
    public DataResult<ProductDTO> getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product == null){
            return new ErrorDataResult<>(null, "Product not found");
        }
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return new SuccessDataResult<>(productDTO, "Product Listed");
    }

    @Override
    public Result addProduct(ProductDTO productDTO) {
        if(productDTO == null){
            return new ErrorResult("Product not found");
        }
        Product product = modelMapper.map(productDTO, Product.class);
        productRepository.save(product);
        return new SuccessResult("Product added");
    }

    @Override
    public Result updateProduct(ProductDTO productDTO, Long id) {

        if(productDTO == null){
            return new ErrorResult("Product not found");
        }
        Product existProduct = productRepository.findById(id).
                orElse(null);
        if(existProduct == null){
            return new ErrorResult("Product not found");
        }
        modelMapper.map(productDTO, existProduct);
        productRepository.save(existProduct);
        return new SuccessDataResult<>(productDTO,"Product updated");
    }

    @Override
    public Result deleteProduct(Long id) {
        if(!productRepository.existsById(id)){
            return new ErrorDataResult<>(null, "Product not found");
        }
        productRepository.deleteById(id);
        return new SuccessResult("Product deleted");
    }

    @Override
    public DataResult<List<ProductDTO>> findByCategoryId(Long categoryId) {
        if(categoryId == null) {
            return new ErrorDataResult<>(null,"Category not found");
        }
        List<Product> products = productRepository.findByCategoryId(categoryId);
        List<ProductDTO> productDTOS = products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(java.util.stream.Collectors.toList());
        return new SuccessDataResult<>(productDTOS, "Product Listed");
    }

    @Override
    public DataResult<List<ProductDTO>> findByNameContaining(String name) {
        if(name == null) {
            return new ErrorDataResult<>(null,"Product not found");
        }
        List<Product> products = productRepository.findByNameContaining(name);
        List<ProductDTO> productDTOS = products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(java.util.stream.Collectors.toList());
        return new SuccessDataResult<>(productDTOS, "Product Listed");
    }

}
