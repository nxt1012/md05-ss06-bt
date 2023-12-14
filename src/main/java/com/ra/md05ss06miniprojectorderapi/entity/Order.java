package com.ra.md05ss06miniprojectorderapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;
//TODO: order là một từ khóa lưu trữ trong SQL nên khi đặt tên bảng là order sẽ gây ra xung đột và lỗi
//TODO: nên tự đặt tên rõ ràng cho bảng bằng @Table(name = "tên_bảng"), tên bảng nên để số nhiều
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @NotNull
    @Column(nullable = false)
    private String shippingAddress;
    @NotNull
    @Column(nullable = false)
    private String phoneNumber;
    private String notes;
    private LocalDateTime createdAt = LocalDateTime.now();
//    TODO: annotation khi sử dụng kiểu enum
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
//    TODO: lưu ý cách khai báo khi khóa ngoại not null với mối quan hệ một-nhiều
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;
//    TODO: tìm hiểu về cascade
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnoreProperties("order")
    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(Long id, Long userId, String shippingAddress, String phoneNumber, String notes, LocalDateTime createdAt, Status status, User user, List<OrderDetail> orderDetails) {
        this.id = id;
        this.userId = userId;
        this.shippingAddress = shippingAddress;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
        this.createdAt = createdAt;
        this.status = status;
        this.user = user;
        this.orderDetails = orderDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
