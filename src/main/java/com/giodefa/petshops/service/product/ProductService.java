package com.giodefa.petshops.service.product;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.giodefa.petshops.dto.ImageDto;
import com.giodefa.petshops.dto.ProductDto;
import com.giodefa.petshops.exceptions.ResourceNotFoundException;
import com.giodefa.petshops.model.Category;
import com.giodefa.petshops.model.Image;
import com.giodefa.petshops.model.Product;
import com.giodefa.petshops.repository.CategoryRepository;
import com.giodefa.petshops.repository.ImageRepository;
import com.giodefa.petshops.repository.ProductRepository;
import com.giodefa.petshops.request.AddProductRequest;
import com.giodefa.petshops.request.ProductUpdateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ImageRepository imageRepository;
    private final ModelMapper modelMapper;

    @Override
    public Product addProduct(AddProductRequest request) {
        // check if the category is found in the DB
        // If yes, set it as the new product category
        // If no, than save as a new cateogry
        // then set as the new product category.
        Category category = Optional.ofNullable(categoryRepository.findByName(request.getCategory().getName())).orElseGet(()->{
                Category newCategory = new Category(request.getCategory().getName());
                return categoryRepository.save(newCategory);
            });
        request.setCategory(category);
        return productRepository.save(createProduct(request, category));
    }

    private Product createProduct(AddProductRequest request, Category category){
        return new Product(
            request.getName(),
            request.getBrand(),
            request.getPrice(),
            request.getInventory(),
            request.getDescription(),
            category
        );
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product not Found!"));
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id)
            .ifPresentOrElse(productRepository::delete,
                    ()-> {throw new ResourceNotFoundException("Product Not Found");});
    }


    private Product updateExistingProduct(Product existingProduct, ProductUpdateRequest request) {
        existingProduct.setName(request.getName());
        existingProduct.setBrand(request.getBrand());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setInventory(request.getInventory());
        existingProduct.setDescirption(request.getDescirption());
        
        Category category = categoryRepository.findByName(request.getCategory().getName());
        existingProduct.setCategory(category);
        return existingProduct;
    }

    @Override
    public Product updateProduct(ProductUpdateRequest request, Long productId) {
        return productRepository.findById(productId)
            .map(existingProduct -> updateExistingProduct(existingProduct, request)) // Update the product
            .map(productRepository::save) // Save the updated product
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategoryName(category);
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
        return productRepository.findByCategoryNameAndBrand(category, brand);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name) {
        return productRepository.findByBrandAndName(brand, name);
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {
        return productRepository.countByBrandAndName(brand, name);
    }

    @Override
    public List<ProductDto> getConvertedProducts(List<Product> products) {
        return products.stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public ProductDto convertToDto(Product product) {
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        List<Image> images = imageRepository.findByProductId(product.getId());
        List<ImageDto> imageDtos = images.stream()
                .map(image -> modelMapper.map(image, ImageDto.class))
                .toList();
        productDto.setImages(imageDtos);
        return productDto;
    }
}
