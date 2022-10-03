package com.project1.NikeClone.repository;

import com.project1.NikeClone.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
