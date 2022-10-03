package com.project1.NikeClone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;
    private String product_name;
    private String product_describe;
    private String product_caterology;
    private String product_avata;
    private Double product_price;

    public Product(String product_name, String product_describe, String product_caterology, String product_avata, Double product_price) {
        this.product_name = product_name;
        this.product_describe = product_describe;
        this.product_caterology = product_caterology;
        this.product_avata = product_avata;
        this.product_price = product_price;
    }
}
