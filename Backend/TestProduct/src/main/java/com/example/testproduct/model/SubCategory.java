package com.example.testproduct.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "sub_category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sub_cate_code")
    private String subCode;
    @Column(name = "sub_cate_name")
    private String subName;
    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category categoryId;
}
