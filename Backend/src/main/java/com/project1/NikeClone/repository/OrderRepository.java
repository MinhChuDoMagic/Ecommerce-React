package com.project1.NikeClone.repository;

import com.project1.NikeClone.entity.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Ordered, Long> {
}
