package com.example.testproduct.repository;

import com.example.testproduct.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select p from Product p where p.productName like :name")
    Product findProductByName(@Param(value = "name")String name);
    @Query("select p from Product p where p.productName like %"+":name%")
    List<Product> seachProductByName(@Param(value = "name")String name);
}
