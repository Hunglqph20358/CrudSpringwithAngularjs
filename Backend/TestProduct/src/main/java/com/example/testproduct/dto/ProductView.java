package com.example.testproduct.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductView implements Serializable {
    private Long id;

    private String productName;
    private String brandName;
    private String SubCategory;
    private Float price;
    private String status;
}
