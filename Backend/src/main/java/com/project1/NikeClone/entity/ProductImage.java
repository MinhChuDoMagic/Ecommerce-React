package com.project1.NikeClone.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "productImage",schema = "prj1_db")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productImage_id;
    private Long productId;
    private String productImage_link;

    public ProductImage(Long productId, String productImage_link) {
        this.productId = productId;
        this.productImage_link = productImage_link;
    }
}
