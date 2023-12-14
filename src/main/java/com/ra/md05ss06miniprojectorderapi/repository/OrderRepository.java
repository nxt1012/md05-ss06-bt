package com.ra.md05ss06miniprojectorderapi.repository;

import com.ra.md05ss06miniprojectorderapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
