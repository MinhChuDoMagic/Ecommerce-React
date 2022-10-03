package com.project1.NikeClone.repository;

import com.project1.NikeClone.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {
    List<ProductSize> findByProductId(Long productId);
    List<ProductSize> deleteByProductId(Long productId);
}
