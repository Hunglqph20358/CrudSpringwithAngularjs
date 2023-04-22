package com.example.testproduct.repository;

import com.example.testproduct.model.ProductBrand;
import com.example.testproduct.model.ProductBrand_Id;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ProductBrandRepository extends JpaRepository<ProductBrand, ProductBrand_Id> {

    @Query("select pb from ProductBrand pb where pb.productId = :productid")
    ProductBrand findBrandById(@Param(value = "productid") Long id);


    @Modifying
    @Query("update ProductBrand pb set pb.productId = :p , pb.brandId = :b where pb.productId = :pId and pb.brandId = :bId")
    void updateProductBrand(@Param(value = "p") Long p, @Param(value = "b") Long b
            , @Param("pId") Long pId, @Param("bId") Long bId);
}
