package com.ra.md05ss06miniprojectorderapi.dto.response;

public class ResponseListOrderDTO {
    private Long orderId;
    private String userName;
    private String phone;
    private String address;

    public ResponseListOrderDTO() {
    }

    public ResponseListOrderDTO(Long orderId, String userName, String phone, String address) {
        this.orderId = orderId;
        this.userName = userName;
        this.phone = phone;
        this.address = address;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
