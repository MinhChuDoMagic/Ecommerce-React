package com.project1.NikeClone.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "productSize")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class ProductSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productSize_id;
    private Long productId;
    private String productSize_name;
    private Long productSize_amount;

    public ProductSize(Long productId, String productSize_name, Long productSize_amount) {
        this.productId = productId;
        this.productSize_name = productSize_name;
        this.productSize_amount = productSize_amount;
    }
}
