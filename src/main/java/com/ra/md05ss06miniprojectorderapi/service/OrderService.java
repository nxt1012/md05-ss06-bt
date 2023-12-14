package com.ra.md05ss06miniprojectorderapi.service;

import com.ra.md05ss06miniprojectorderapi.entity.Order;
import com.ra.md05ss06miniprojectorderapi.entity.OrderDetail;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    Order save(Order order);

    Order getOrderById(Long id);

    Order update(Long id, Order order);

    boolean delete(Long id);

}
