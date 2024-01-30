package org.work.springbootwork.service.abstracts;

import org.work.springbootwork.core.results.DataResult;
import org.work.springbootwork.core.results.Result;
import org.work.springbootwork.dto.CustomerDTO;
import org.work.springbootwork.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    DataResult<List<ProductDTO>> gettAllProduct();
    DataResult<ProductDTO> getProductById(Long id);
    Result addProduct(ProductDTO productDTO);
    Result updateProduct(ProductDTO productDTO, Long id);
    Result deleteProduct(Long id);
    DataResult<List<ProductDTO>> findByCategoryId(Long categoryId);
    DataResult<List<ProductDTO>> findByNameContaining(String name);
    DataResult<List<ProductDTO>> findProductsByOrderId(Long orderId);
}
