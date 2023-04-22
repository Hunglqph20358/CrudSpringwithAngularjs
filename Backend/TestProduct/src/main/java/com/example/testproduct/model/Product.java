package com.example.testproduct.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "subcate_id")
    private SubCategory subCategory;
    @Column(name = "produce_name")
    private String productName;
    @Column(name = "color")
    private String color;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "sell_price")
    private Float sellPrice;
    @Column(name = "origin_price")
    private Float originPrice;
    @Column(name = "description")
    private String desciption;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status statusId;
}
