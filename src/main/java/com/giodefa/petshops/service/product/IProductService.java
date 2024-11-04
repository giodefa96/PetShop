package com.giodefa.petshops.service.product;

import java.util.List;

import com.giodefa.petshops.dto.ProductDto;
import com.giodefa.petshops.model.Product;
import com.giodefa.petshops.request.AddProductRequest;
import com.giodefa.petshops.request.ProductUpdateRequest;

public interface IProductService {
    Product addProduct(AddProductRequest request);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(ProductUpdateRequest product, Long productId);

    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand, String name);
    
    Long countProductsByBrandAndName(String category, String name);

    public ProductDto convertToDto(Product product);
    public List<ProductDto> getConvertedProducts(List<Product> products);
}
