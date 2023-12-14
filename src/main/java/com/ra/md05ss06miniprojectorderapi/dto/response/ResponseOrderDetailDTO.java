package com.ra.md05ss06miniprojectorderapi.dto.response;

public class ResponseOrderDetailDTO {
    private String productName;
    private String imageUrl;
    private double price;
    private int quantity;

    public ResponseOrderDetailDTO() {
    }

    public ResponseOrderDetailDTO(String productName, String imageUrl, double price, int quantity) {
        this.productName = productName;
        this.imageUrl = imageUrl;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
