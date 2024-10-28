package com.giodefa.request;

import java.math.BigDecimal;

import com.giodefa.model.Category;

import lombok.Data;

@Data
public class AddProductRequest {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String descirption;
    private Category category;
}
