package com.lukasz2.SpringBootEcomLearnApp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String customerEmail;
private String status;
private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        this.status = "PENDING";
        this.createdAt = LocalDateTime.now();
    }
//    @Past(message = "Order date must be in the past"
//
//    )
//    private LocalDate orderDate;
//    @PastOrPresent(message = "Payment date must be in the past or present")
//    private LocalDate paymentDate;
//
//    @Future(message = "Delivery date must be in the future")
//    private LocalDate deliveryDate;
//    @FutureOrPresent(message="Shipment date must be in the present or future")
//    private LocalDate shipmentDate;
//    @Email(message = "Customer email should be valid")
//    private String customerEmail;
//
//    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Order reference must be alphanumeric")
//    private String orderReference;
//
//    @AssertTrue(message = "Order must be confirmed")
//    private Boolean confirmed;



//    public Order() {}
//    public Order(LocalDate orderDate, LocalDate paymentDate, LocalDate deliveryDate, LocalDate shipmentDate) {
//        this.orderDate = orderDate;
//        this.paymentDate = paymentDate;
//        this.deliveryDate = deliveryDate;
//        this.shipmentDate = shipmentDate;
//    }

}
