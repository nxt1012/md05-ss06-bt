package com.ra.md05ss06miniprojectorderapi.dto.request;

import java.util.List;

public class OrderCreationDTO {
    private Long userId;
    private String notes;
    private String phoneNumber;
    private String shippingAddress;
    private List<OrderDetailDTO> orderDetails;

    public OrderCreationDTO() {
    }

    public OrderCreationDTO(Long userId, String notes, String phoneNumber, String shippingAddress, List<OrderDetailDTO> orderDetails) {
        this.userId = userId;
        this.notes = notes;
        this.phoneNumber = phoneNumber;
        this.shippingAddress = shippingAddress;
        this.orderDetails = orderDetails;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
