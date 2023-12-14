package com.ra.md05ss06miniprojectorderapi.dto.request;


public class OrderDetailDTO {

    private Long productId;
    private int quantity;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
