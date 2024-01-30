package org.work.springbootwork.service.concretes;

import org.work.springbootwork.core.results.DataResult;
import org.work.springbootwork.core.results.Result;
import org.work.springbootwork.dto.ProductDTO;
import org.work.springbootwork.service.abstracts.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    @Override
    public DataResult<List<ProductDTO>> gettAllProduct() {
        return null;
    }

    @Override
    public DataResult<ProductDTO> getProductById(Long id) {
        return null;
    }

    @Override
    public Result addProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public Result updateProduct(ProductDTO productDTO, Long id) {
        return null;
    }

    @Override
    public Result deleteProduct(Long id) {
        return null;
    }

    @Override
    public DataResult<List<ProductDTO>> findByCategoryId(Long categoryId) {
        return null;
    }

    @Override
    public DataResult<List<ProductDTO>> findByNameContaining(String name) {
        return null;
    }

    @Override
    public DataResult<List<ProductDTO>> findProductsByOrderId(Long orderId) {
        return null;
    }
}
