package com.ra.md05ss06miniprojectorderapi.service;

import com.ra.md05ss06miniprojectorderapi.entity.OrderDetail;
import com.ra.md05ss06miniprojectorderapi.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @Override
    public List<OrderDetail> getOrderDetailsByOrderId(Long id) {
        return orderDetailRepository.getOrderDetailByOrder_Id(id);
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail getOrderDetailById(Long id) {
        return orderDetailRepository.findById(id).orElse(null);
    }

    @Override
    public OrderDetail update(Long id, OrderDetail orderDetail) {
        Optional<OrderDetail> optionalExistingOrderDetail = orderDetailRepository.findById(id);
        if (optionalExistingOrderDetail.isPresent()) {
            OrderDetail existingOrderDetail = optionalExistingOrderDetail.get();
            existingOrderDetail.setOrder(orderDetail.getOrder());
            existingOrderDetail.setProduct(orderDetail.getProduct());
            existingOrderDetail.setQuantity(orderDetail.getQuantity());
            return orderDetailRepository.save(existingOrderDetail);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(id);
        if (optionalOrderDetail.isPresent()) {
            orderDetailRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
