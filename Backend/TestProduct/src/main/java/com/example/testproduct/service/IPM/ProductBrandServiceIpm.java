package com.example.testproduct.service.IPM;

import com.example.testproduct.model.ProductBrand;
import com.example.testproduct.model.ProductBrand_Id;
import com.example.testproduct.repository.ProductBrandRepository;
import com.example.testproduct.service.ProductBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBrandServiceIpm implements ProductBrandService {
    @Autowired
    private ProductBrandRepository productBrandRepository;
    @Override
    public List<ProductBrand> getAllProductBrand() {
        return productBrandRepository.findAll();
    }

    @Override
    public ProductBrand addProductBrand(ProductBrand productBrand) {
        return productBrandRepository.save(productBrand);
    }

    @Override
    public void updateProductBrand(ProductBrand productBrand) {
        ProductBrand brand = productBrandRepository.findBrandById(productBrand.getProductId());
        productBrandRepository.updateProductBrand(productBrand.getProductId(),productBrand.getBrandId(), brand.getProductId(), brand.getBrandId());
    }

}
