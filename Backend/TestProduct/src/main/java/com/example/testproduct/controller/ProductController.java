package com.example.testproduct.controller;

import com.example.testproduct.dto.ProductDTO;
import com.example.testproduct.dto.ProductView;
import com.example.testproduct.model.Product;
import com.example.testproduct.model.ProductBrand;
import com.example.testproduct.model.ProductBrand_Id;
import com.example.testproduct.service.ProductBrandService;
import com.example.testproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500/")
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductBrandService productBrandService;
    @Autowired
    private ProductService productService;


    @GetMapping("/product")
    public ResponseEntity<List<ProductView>> getall() {
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> detailProduct(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(productService.detailProduct(id),HttpStatus.OK);
    }

    @GetMapping("/product/seach/{productName}")
    public ResponseEntity<List<ProductView>> seachProduct(@PathVariable String productName){
        return new ResponseEntity<>(productService.seachProduct(productName),HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct( @RequestBody ProductDTO productDTO) {
        Product p = productService.addProduct(productDTO);
        ProductBrand productBrand = new ProductBrand(p.getId(), productDTO.getBrandId());
        productBrandService.addProductBrand(productBrand);
        return new ResponseEntity<>(p,HttpStatus.CREATED);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> upadteProduct(@PathVariable(value = "id")Long id,@RequestBody ProductDTO productDTO){

        ProductBrand productBrand = new ProductBrand(id,productDTO.getBrandId());
        productBrandService.updateProductBrand(productBrand);
        Product p = productService.updateProduct(id,productDTO);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable(value = "id") Long id){
        productService.deleteProduct(id);
    }
}
