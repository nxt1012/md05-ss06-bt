package com.ra.md05ss06miniprojectorderapi.repository;

import com.ra.md05ss06miniprojectorderapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
