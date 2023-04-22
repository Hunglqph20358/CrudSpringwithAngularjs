package com.example.testproduct.repository;

import com.example.testproduct.model.Status;
import com.example.testproduct.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {
    @Query("select s from Status s where s.id = :id")
    Status fillByID(@Param(value = "id") Long id);
}
