package com.ra.md05ss06miniprojectorderapi.service;

import com.ra.md05ss06miniprojectorderapi.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> getAllOrderDetails();
    List<OrderDetail> getOrderDetailsByOrderId(Long id);

    OrderDetail save(OrderDetail orderDetail);

    OrderDetail getOrderDetailById(Long id);

    OrderDetail update(Long id, OrderDetail orderDetail);

    boolean delete(Long id);
}
