package com.example.testproduct.service.IPM;

import com.example.testproduct.model.SubCategory;
import com.example.testproduct.repository.SubCateRepository;
import com.example.testproduct.service.SubCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCateServiceIpm implements SubCateService{
    @Autowired
    private SubCateRepository subCateRepository;
    @Override
    public List<SubCategory> getAllSub() {
        return subCateRepository.findAll();
    }
}
