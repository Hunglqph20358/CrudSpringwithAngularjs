package com.example.testproduct.controller;

import com.example.testproduct.model.Brand;
import com.example.testproduct.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/brand")
    public ResponseEntity<List<Brand>> getAllBrand(){
        return new ResponseEntity<>(brandService.getAllBrand(), HttpStatus.OK);
    }
}
