package com.project1.NikeClone.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
@Getter
@NoArgsConstructor
public class Ordered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String order_address;
    private String order_phone;
    private Date order_date;
    private Long product_id;
    private String order_size;

    private Double order_price;
    private Long user_id;
}
