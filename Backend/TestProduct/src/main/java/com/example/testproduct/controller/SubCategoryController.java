package com.example.testproduct.controller;

import com.example.testproduct.model.SubCategory;
import com.example.testproduct.service.SubCateService;
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
public class SubCategoryController {
    @Autowired
    private SubCateService subCateService;

    @GetMapping("/subcate")
    public ResponseEntity<List<SubCategory>> getAllSub(){
        return new ResponseEntity<>(subCateService.getAllSub(), HttpStatus.OK);
    }
}
