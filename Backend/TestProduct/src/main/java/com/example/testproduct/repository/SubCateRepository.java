package com.example.testproduct.repository;

import com.example.testproduct.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCateRepository extends JpaRepository<SubCategory,Long> {
    @Query("select s from SubCategory s where s.id = :id")
    SubCategory fillByID(@Param(value = "id") Long id);
}
