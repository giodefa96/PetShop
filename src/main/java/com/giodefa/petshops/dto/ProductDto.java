package com.giodefa.petshops.dto;

import java.math.BigDecimal;
import java.util.List;

import com.giodefa.petshops.model.Category;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String descirption;
    private Category category;
    private List<ImageDto> images;
}