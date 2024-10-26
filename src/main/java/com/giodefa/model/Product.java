package com.giodefa.model;

import java.math.BigDecimal;
import java.util.List;

public class Product {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String descirption;

    private Category category;

    private List<Image> images;
}
