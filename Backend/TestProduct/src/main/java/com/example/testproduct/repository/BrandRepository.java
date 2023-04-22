package com.example.testproduct.repository;

import com.example.testproduct.model.Brand;
import com.example.testproduct.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("select b from Brand b where b.id = :id")
    Brand fillByID(@Param(value = "id") Long id);
}
