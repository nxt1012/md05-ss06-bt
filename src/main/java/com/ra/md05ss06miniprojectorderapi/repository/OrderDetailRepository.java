package com.ra.md05ss06miniprojectorderapi.repository;

import com.ra.md05ss06miniprojectorderapi.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> getOrderDetailByOrder_Id(Long id);
}
