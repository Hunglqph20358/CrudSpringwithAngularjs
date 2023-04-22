package com.example.testproduct.service;

import com.example.testproduct.dto.ProductDTO;
import com.example.testproduct.dto.ProductView;
import com.example.testproduct.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductView> getAllProduct();

    List<ProductView> seachProduct(String productName);

    Product addProduct(ProductDTO productDTO);

    void deleteProduct(Long id);
    ProductDTO detailProduct(Long Id);

    Product updateProduct(Long id, ProductDTO productDTO);
}
