package com.example.testproduct.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "product_brand")
@IdClass(ProductBrand_Id.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductBrand implements Serializable {
//    @EmbeddedId
//    private ProductBrand_Id productBrandId;
//    @ManyToOne
//    @MapsId("productId")
//    @JoinColumn(name = "product_id")
//    @JsonIgnore
//    private Product product;
//
//    @ManyToOne
//    @MapsId("brandId")
//    @JoinColumn(name = "brand_id")
//    @JsonIgnore
//    private Brand brand;
    @Id
    @Column(name = "product_id")
    private Long productId;
    @Id
    @Column(name = "brand_id")
    private Long brandId;
}
