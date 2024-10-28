package com.giodefa.service.product;

import java.util.List;

import com.giodefa.model.Product;
import com.giodefa.repository.ProductRepository;
import com.giodefa.exceptions.ProductNotFoundException;

public class ProductService implements IProductService {
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Product not Found!"));
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id).ifPresent(productRepository::delete);
    }

    @Override
    public void updateProduct(Product product, Long productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    @Override
    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
    }

    @Override
    public List<Product> getProductsByCategoryId(String category) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByCategoryId'");
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByBrand'");
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByCategoryAndBrand'");
    }

    @Override
    public List<Product> getProductsByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByName'");
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByBrandAndName'");
    }

    @Override
    public Long countProductsByBrandAndName(String category, String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'countProductsByBrandAndName'");
    }

}
