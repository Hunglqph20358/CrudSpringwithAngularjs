package com.example.testproduct.service;

import com.example.testproduct.model.ProductBrand;
import com.example.testproduct.model.ProductBrand_Id;

import java.util.List;

public interface ProductBrandService {
    List<ProductBrand> getAllProductBrand();
    ProductBrand addProductBrand(ProductBrand productBrand);
    void updateProductBrand(ProductBrand productBrand);

}
