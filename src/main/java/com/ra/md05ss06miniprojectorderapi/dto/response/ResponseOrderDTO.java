package com.ra.md05ss06miniprojectorderapi.dto.response;

import com.ra.md05ss06miniprojectorderapi.entity.Status;

import java.time.LocalDateTime;
import java.util.List;

public class ResponseOrderDTO {
    private Long id;
    private String userName;
    private List<ResponseOrderDetailDTO> orderDetails;

    public ResponseOrderDTO() {
    }

    public ResponseOrderDTO(Long id, String userName, List<ResponseOrderDetailDTO> orderDetails) {
        this.id = id;
        this.userName = userName;
        this.orderDetails = orderDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<ResponseOrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<ResponseOrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
