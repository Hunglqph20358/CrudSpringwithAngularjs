package com.example.testproduct.service.IPM;

import com.example.testproduct.model.Brand;
import com.example.testproduct.repository.BrandRepository;
import com.example.testproduct.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceIpm implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrand() {
        return brandRepository.findAll();
    }
}
