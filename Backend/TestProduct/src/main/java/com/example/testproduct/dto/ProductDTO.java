package com.example.testproduct.dto;

import com.example.testproduct.model.Status;
import com.example.testproduct.model.SubCategory;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO implements Serializable {
    private Long id;

    private String productName;
    private String color;
    private Long quantity;
    private Float sellPrice;
    private Float originPrice;
    private String desciption;
    private Long subCategoryId;
    private Long statusId;
    private Long brandId;
}
