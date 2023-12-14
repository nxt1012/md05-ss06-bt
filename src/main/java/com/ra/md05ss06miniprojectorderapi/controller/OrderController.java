package com.ra.md05ss06miniprojectorderapi.controller;

import com.ra.md05ss06miniprojectorderapi.dto.request.OrderCreationDTO;
import com.ra.md05ss06miniprojectorderapi.dto.request.OrderDetailDTO;
import com.ra.md05ss06miniprojectorderapi.dto.response.ResponseListOrderDTO;
import com.ra.md05ss06miniprojectorderapi.dto.response.ResponseOrderDTO;
import com.ra.md05ss06miniprojectorderapi.dto.response.ResponseOrderDetailDTO;
import com.ra.md05ss06miniprojectorderapi.entity.Order;
import com.ra.md05ss06miniprojectorderapi.entity.OrderDetail;
import com.ra.md05ss06miniprojectorderapi.entity.Product;
import com.ra.md05ss06miniprojectorderapi.entity.User;
import com.ra.md05ss06miniprojectorderapi.service.OrderDetailService;
import com.ra.md05ss06miniprojectorderapi.service.OrderService;
import com.ra.md05ss06miniprojectorderapi.service.ProductService;
import com.ra.md05ss06miniprojectorderapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;
    private final OrderDetailService orderDetailService;
    private final ProductService productService;

    @Autowired
    public OrderController(UserService userService, OrderService orderService, OrderDetailService orderDetailService, ProductService productService) {
        this.userService = userService;
        this.orderService = orderService;
        this.orderDetailService = orderDetailService;
        this.productService = productService;
    }

    //    GET ALL
    @GetMapping
    public ResponseEntity<List<ResponseListOrderDTO>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();

        List<ResponseListOrderDTO> responseListOrderDTOs = orders.stream().map(order -> {
            ResponseListOrderDTO responseListOrderDTO = new ResponseListOrderDTO();
            responseListOrderDTO.setOrderId(order.getId());
            responseListOrderDTO.setUserName(order.getUser().getUserName()); // Assuming the user's name is available in the User entity
            responseListOrderDTO.setPhone(order.getPhoneNumber());
            responseListOrderDTO.setAddress(order.getShippingAddress());
            return responseListOrderDTO;
        }).toList();

        return ResponseEntity.ok(responseListOrderDTOs);
    }

    //    GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.notFound().build();
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ResponseOrderDTO> create(@RequestBody OrderCreationDTO orderDTO) {
        User user = userService.getUserById(orderDTO.getUserId());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Order order = new Order();
        order.setUserId(orderDTO.getUserId());
        order.setShippingAddress(orderDTO.getShippingAddress());
        order.setPhoneNumber(orderDTO.getPhoneNumber());
        order.setNotes(orderDTO.getNotes());
        order.setUser(user);

        Order savedOrder = orderService.save(order);

        List<OrderDetailDTO> orderDetailDTOs = orderDTO.getOrderDetails();
        if (orderDetailDTOs != null && !orderDetailDTOs.isEmpty()) {
            for (OrderDetailDTO orderDetailDTO : orderDetailDTOs) {
                Product product = productService.getProductById(orderDetailDTO.getProductId());
                if (product != null) {
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setOrder(savedOrder);
                    orderDetail.setProduct(product);
                    orderDetail.setQuantity(orderDetailDTO.getQuantity());
                    orderDetailService.save(orderDetail);
                }
            }
        }
        ResponseOrderDTO responseOrderDTO = mapOrderToResponseOrderDTO(savedOrder);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseOrderDTO);
    }



    //    UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order updateOrder) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            Order updatedOrder = orderService.update(id, order);
            return ResponseEntity.ok(updatedOrder);
        }
        return ResponseEntity.notFound().build();
    }

    //    DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = orderService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseOrderDTO mapOrderToResponseOrderDTO(Order savedOrder) {
        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
        responseOrderDTO.setId(savedOrder.getId());
        responseOrderDTO.setUserName(savedOrder.getUser().getUserName());

        //map OrderDetail to ResponseOrderDetailDTO
        List<OrderDetail> orderDetails = orderDetailService.getOrderDetailsByOrderId(savedOrder.getId());
        List<ResponseOrderDetailDTO> responseOrderDetailDTOs = orderDetails.stream().map(orderDetail -> {
            ResponseOrderDetailDTO responseOrderDetailDTO = new ResponseOrderDetailDTO();
            responseOrderDetailDTO.setProductName(orderDetail.getProduct().getProductName());
            responseOrderDetailDTO.setImageUrl(orderDetail.getProduct().getImageUrl());;
            responseOrderDetailDTO.setPrice(orderDetail.getProduct().getPrice());
            responseOrderDetailDTO.setQuantity(orderDetail.getQuantity());
            return responseOrderDetailDTO;
        }).toList();
        responseOrderDTO.setOrderDetails(responseOrderDetailDTOs);
        return responseOrderDTO;
    }
}
